package com.jestify.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
    public static String getUserCurrently() {
        String currentEmail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return currentEmail;
    }
}
