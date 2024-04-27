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
    public static final String GET_PRODUCT = "/api/products/**";
    public static final String ADD_PRODUCT = "/api/products/add";
    public static final String UPDATE_PRODUCT = "/api/products/update";
    public static final String ADD_TO_CART = "/api/cart/add";
    public static final String VIEW_CART = "/api/cart";
    public static final String ORDER = "/api/orders/create";
    public static final String VIEW_ORDER = "/api/orders";
    public static final String VIEW_ORDER_DETAIL = "/api/orders/{id}";
    public static final String CHANGE_QUANTITY = "/api/cart/change-quantity";
    public static final String CREATE_TICKET = "/api/tickets/create";
    public static final String FIND_TICKET = "/api/tickets";
    public static final String FIND_TICKET_DETAIL = "/api/tickets/**";
    public static final String EXTEND_TICKET = "/api/user-ticket/extend";
    public static final String BUY_TICKET = "/api/user-ticket/buy";
    public static final String UPDATE_FACILITY_PRODUCT = "/api/facility-product/update";
    public static final String FIND_VOUCHERS = "/api/vouchers";
    public static final String TICKET_HISTORY = "/api/user-ticket";
    public static final String IMAGE = "/image/**";
    public static final String FIND_FACILITY = "/api/facilities";
    public static final String FIND_CATEGORY = "/api/categories";
    public static final String FIND_SUPPLIER = "/api/suppliers";
    public static final String FIND_TRAIN_TIME = "/api/train-time";
    public static final String BOOKING = "/api/booking/create";

    public static final List<String> FREE_API = Arrays.asList(
            SIGN_IN,
            SIGN_UP,
            FORGET_PASSWORD,
            GET_PRODUCT,
            FIND_TICKET,
            FIND_TICKET_DETAIL,
            FIND_VOUCHERS,
            IMAGE,
            FIND_FACILITY,
            FIND_CATEGORY,
            FIND_SUPPLIER,
            "/vnpay_jsp/vnpay_return.jsp",
            "/api/payment/info",
            FIND_TRAIN_TIME
    );
}
