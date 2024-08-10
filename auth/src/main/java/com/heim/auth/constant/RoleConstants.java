package com.heim.auth.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleConstants {
    public static final String USER = "USER";
    public static final String OWNER = "OWNER";
    public static final String MANAGER = "MANAGER";
    public static final String WORKER = "WORKER";
}