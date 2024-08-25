package com.spotbooker.auth.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageConstants {
    // Validation messages
    public static final String BLANK_FIELD = "Field can not be blank!";
    public static final String INVALID_EMAIL = "Invalid email!";
    public static final String INVALID_PHONE = "Invalid phone!";
    public static final String INVALID_NAME_FORMAT = "Name must start with capital letter and contain only characters.";
    public static final String INVALID_FIRST_NAME = "Invalid first name! "+ INVALID_NAME_FORMAT;
    public static final String INVALID_LAST_NAME = "Invalid last name! "+ INVALID_NAME_FORMAT;
    public static final String INVALID_PASSWORD = "Invalid password! Password must contain at least one uppercase " +
            "letter, number or symbol and be of minimum length 8.";
    public static final String PASSWORD_MISMATCH = "Password and confirm password do not match!";

    // User request error messages
    public static final String USER_EXISTS_EMAIL = "A user with the given email already exists!";
    public static final String USER_EXISTS_PHONE = "A user with the given phone already exists!";

    // Role request error messages
    public static final String ROLE_NOT_FOUND = "Role not found!";

    // Internal server error message
    public static final String INTERNAL_SERVER_ERROR = "Internal server error!";
}