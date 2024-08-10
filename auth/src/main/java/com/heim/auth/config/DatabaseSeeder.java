package com.heim.auth.config;

import com.heim.auth.constant.RoleConstants;
import com.heim.auth.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final RoleService roleService;

    @Override
    @Transactional
    public void run(String... args) {
        final var roles = ConstantsUtil.getAllConstants(RoleConstants.class);

        roles.forEach(this.roleService::seedRole);
    }
}