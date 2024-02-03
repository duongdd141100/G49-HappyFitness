package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandleController {
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<BaseResponse<String>> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseResponse.unAuthentication(e.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BaseResponse<String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.fail(e.getMessage()));
    }
}
