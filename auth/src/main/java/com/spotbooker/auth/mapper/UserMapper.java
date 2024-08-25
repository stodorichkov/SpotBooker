package com.spotbooker.auth.mapper;

import com.spotbooker.auth.config.PasswordEncoder;
import com.spotbooker.auth.model.entity.User;
import com.spotbooker.auth.model.payload.event.UserRegistrationEvent;
import com.spotbooker.auth.model.payload.request.UserRegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PasswordEncoder.class)
public interface UserMapper {
    @Mapping(target = "password", qualifiedByName = "encode")
    User map(UserRegistrationRequest request);

    UserRegistrationEvent map(User user, UserRegistrationRequest userRegistrationRequest);
}