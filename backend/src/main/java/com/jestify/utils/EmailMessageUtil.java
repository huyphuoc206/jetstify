package com.jestify.utils;

public class EmailMessageUtil {

    public static final String VERIFY_REGISTER_SUBJECT = "Jestify - Please verify your registration";
    public static final String RESET_PASSWORD_SUBJECT = "Jestify - Reset password";

    public static String verifyRegister(String name, String link) {
        String sb = "Dear " +
                name +
                ",\n" +
                "Please click the link below to verify your registration.\n\n" +
                link +
                "\n\nThank you." +
                "\nJestify Team";
        return sb;
    }

    public static String resetPassword(String name, String link) {
        String sb = "Dear " +
                name +
                ",\n" +
                "Please click the link below to reset the password for your Jestify account.\n\n" +
                link +
                "\nNote: The link will be expired within 24 hours." +
                "\n\nThank you." +
                "\nJestify Team";
        return sb;
    }
}
