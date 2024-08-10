package com.heim.auth.service;

import com.heim.auth.model.entity.Role;
import com.heim.auth.repository.RoleRepository;
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