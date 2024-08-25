package com.spotbooker.auth.config;

import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends BCryptPasswordEncoder {
    @Named("encode")
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }
}