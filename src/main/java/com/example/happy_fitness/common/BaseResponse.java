package com.example.happy_fitness.common;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class BaseResponse<T> {
    private String code;

    private String message;

    private T body;

    public static BaseResponse ok(Object body) {
        return new BaseResponse<>(ResponseCodeEnum.OK.getCode(), ResponseCodeEnum.OK.getMessage(), body);
    }

    public static BaseResponse fail(String message) {
        return new BaseResponse<>(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), message);
    }

    public static BaseResponse unAuthentication(String message) {
        return new BaseResponse<>(ResponseCodeEnum.UN_AUTHENTICATION.getCode(), ResponseCodeEnum.UN_AUTHENTICATION.getMessage(), message);
    }

    public BaseResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
