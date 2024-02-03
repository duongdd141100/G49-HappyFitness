package com.example.happy_fitness.common;

import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Data
public class BaseResponse<T> {
    private Integer code;

    private String message;

    private T body;

    public static BaseResponse ok(Object body) {
        return new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), body);
    }

    public static BaseResponse fail(String message) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), message);
    }

    public static BaseResponse unAuthentication(String message) {
        return new BaseResponse<>(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), message);
    }

    public BaseResponse(Integer code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
