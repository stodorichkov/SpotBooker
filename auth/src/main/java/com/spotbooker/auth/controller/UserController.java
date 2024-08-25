package com.spotbooker.auth.controller;

import com.spotbooker.auth.model.payload.request.UserRegistrationRequest;
import com.spotbooker.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void register(@Valid @RequestBody UserRegistrationRequest request) {
        this.userService.register(request);
    }
}