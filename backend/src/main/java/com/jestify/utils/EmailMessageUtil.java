package com.jestify.utils;

public class EmailMessageUtil {

    public static final String VERIFY_REGISTER_SUBJECT = "Jestify - Please verify your registration";

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
}
