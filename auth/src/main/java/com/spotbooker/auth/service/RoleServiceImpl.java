package com.spotbooker.auth.service;

import com.spotbooker.auth.model.entity.Role;
import com.spotbooker.auth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public void seedRole(String name) {
        if(this.roleRepository.findByName(name).isPresent()) {
            return;
        }

        final var role = new Role();
        role.setName(name);

        this.roleRepository.save(role);
    }
}