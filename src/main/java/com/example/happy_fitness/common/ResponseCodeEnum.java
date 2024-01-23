package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    OK("200", "Successfully"),
    FAILED("400", "Bad Request"),
    UN_AUTHENTICATION("401", "UnAuthentication");

    private String code;

    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
