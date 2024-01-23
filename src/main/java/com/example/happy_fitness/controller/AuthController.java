package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.config.UserAuthProvider;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserAuthProvider userAuthProvider;

    @Autowired
    private AuthService authService;
    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse<String>> signIn(@AuthenticationPrincipal User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(userAuthProvider.createToken(user.getUsername())));
        } catch (Exception e) {
            log.error(RequestMappingConstant.SIGN_IN + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<String>> signUp(@RequestBody User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(authService.save(user)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.SIGN_IN + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
