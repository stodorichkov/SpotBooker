package com.spotbooker.auth.model.payload.request;

import com.spotbooker.auth.constant.MessageConstants;
import com.spotbooker.auth.constant.RegexConstants;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRegistrationRequest(
        
        @Pattern(regexp = RegexConstants.NAME_REGEX, message = MessageConstants.INVALID_FIRST_NAME)
        String firstName,

        @Pattern(regexp = RegexConstants.NAME_REGEX, message = MessageConstants.INVALID_LAST_NAME)
        String lastName,

        @Pattern(regexp = RegexConstants.PHONE_REGEX, message = MessageConstants.INVALID_PHONE)
        String phone,

        @Pattern(regexp = RegexConstants.EMAIL_REGEX, message = MessageConstants.INVALID_EMAIL)
        String email,

        @Pattern(regexp = RegexConstants.PASSWORD_REGEX, message = MessageConstants.INVALID_PASSWORD)
        String password,

        @NotBlank(message = MessageConstants.BLANK_FIELD)
        String confirmPassword
) {
    @AssertTrue(message = MessageConstants.PASSWORD_MISMATCH)
    public boolean isPasswordMatch() {
        return password().equals(confirmPassword());
    }
}