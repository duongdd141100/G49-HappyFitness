package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {
    LOGIN_FAILED("001001", "Login Failed"),

    TOKEN_EMPTY("001002", "Token Empty"),

    TOKEN_INVALID("001003", "Token Invalid"),

    CREATE_TOKEN_FAILED("001004", "Create Token Failed"),

    LACK_OF_INFORMATION("001005", "Lack Of Information"),

    USERNAME_EXIST("001006", "Username is exist! Please choose new username!"),

    USERNAME_NOT_EXIST("001007", "Username is not exist!"),

    /**
     * Error message for email
     */
    EMAIL_NOT_EXIST("002001", "Email not exist!"),

    SEND_MAIL_FAILED("002002", "Send mail failed!"),

    /**
     * Error message for authentication
     */
    ERROR_CREATE_NEW_USER_BECAUSE_ROLE("003001", "You cannot create new user with Admin, Manager or Customer role!"),

    ERROR_CREATE_NEW_USER_BECAUSE_FACILITY("003002", "You cannot create new user for other facility!"),

    ACCESS_DENIED_VIEW_USER_DETAIL("003003", "You can view only employee in your facility!"),

    ACCESS_DENIED_RESET_PASSWORD("003004", "You can reset only password of employee in your facility!"),;

    private String code;

    private String message;

    ErrorMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorMessageEnum typeOf(String code) {
        for (ErrorMessageEnum messageEnum : ErrorMessageEnum.values()) {
            if (messageEnum.code.equals(code)) {
                return messageEnum;
            }
        }
        throw new IllegalArgumentException(code);
    }
}
