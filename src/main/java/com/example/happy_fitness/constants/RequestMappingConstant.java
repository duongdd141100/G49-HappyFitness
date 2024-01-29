package com.example.happy_fitness.constants;

import java.util.Arrays;
import java.util.List;

public class RequestMappingConstant {
    public static final String SIGN_IN = "/api/auth/sign-in";
    public static final String SIGN_UP = "/api/auth/sign-up";

    public static final List<String> FREE_API = Arrays.asList(
            SIGN_IN,
            SIGN_UP
    );
}
