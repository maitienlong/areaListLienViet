package com.example.beta3.Services;

public class LCConfig {
    private static String authorization;

    public static void setAuthorization(String authorization) {
        LCConfig.authorization = authorization;
    }

    public static String getAuthorization() {
        return authorization;
    }
}
