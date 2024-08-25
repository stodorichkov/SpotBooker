package com.spotbooker.auth.service;

import com.spotbooker.auth.constant.MessageConstants;
import com.spotbooker.auth.constant.RoleConstants;
import com.spotbooker.auth.exception.BadRequestException;
import com.spotbooker.auth.exception.NotFoundException;
import com.spotbooker.auth.mapper.UserMapper;
import com.spotbooker.auth.model.entity.User;
import com.spotbooker.auth.model.payload.event.UserRegistrationEvent;
import com.spotbooker.auth.model.payload.request.UserRegistrationRequest;
import com.spotbooker.auth.repository.RoleRepository;
import com.spotbooker.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final TopicNameService topicNameService;

    private final UserMapper userMapper;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void register(UserRegistrationRequest request) {
        this.userRepository.findByEmailOrPhone(request.email(), request.phone())
                .ifPresentOrElse(
                        existingUser -> {
                            throw new BadRequestException(existingUser.getEmail().equals(request.email())
                                    ? MessageConstants.USER_EXISTS_EMAIL
                                    : MessageConstants.USER_EXISTS_PHONE
                            );
                        },
                        () -> {
                            final var user = this.userMapper.map(request);
                            final var role = this.roleRepository
                                    .findByName(RoleConstants.USER)
                                    .orElseThrow(() -> new NotFoundException(MessageConstants.ROLE_NOT_FOUND));

                            user.setRole(role);

                            final var savedUser = this.userRepository.save(user);

                            this.publishUserDetails(savedUser, request);
                        }
                );
    }

    private void publishUserDetails(User user, UserRegistrationRequest userRegistrationRequest) {
        this.kafkaTemplate.send(
                this.topicNameService.getTopicName(UserRegistrationEvent.class),
                this.userMapper.map(user, userRegistrationRequest)
        );
    }
}