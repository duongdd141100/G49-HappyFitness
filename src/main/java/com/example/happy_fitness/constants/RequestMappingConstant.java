package com.example.happy_fitness.constants;

import java.util.Arrays;
import java.util.List;

public class RequestMappingConstant {
    public static final String SIGN_IN = "/api/auth/sign-in";
    public static final String SIGN_UP = "/api/auth/sign-up";
    public static final String EDIT_PROFILE = "/api/auth/edit-profile";
    public static final String CHANGE_PASSWORD = "/api/auth/change-password";
    public static final String FORGET_PASSWORD = "/api/auth/forget-password/**";
    public static final String FIND_USER = "/api/users";
    public static final String CREATE_USER = "/api/users/create";
    public static final String USER_DETAIL = "/api/users/{username}";
    public static final String RESET_PASSWORD = "/api/users/reset-password/{username}";
    public static final String DEACTIVATE = "/api/users/deactivate/{username}";
    public static final String REVENUE = "/api/dashboard/revenue";
    public static final String GET_PRODUCT = "/api/products";

    public static final List<String> FREE_API = Arrays.asList(
            SIGN_IN,
            SIGN_UP,
            FORGET_PASSWORD,
            GET_PRODUCT
    );
}
