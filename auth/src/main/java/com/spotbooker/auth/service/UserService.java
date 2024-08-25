package com.spotbooker.auth.service;

import com.spotbooker.auth.model.payload.request.UserRegistrationRequest;

public interface UserService {
    void register(UserRegistrationRequest request);
}