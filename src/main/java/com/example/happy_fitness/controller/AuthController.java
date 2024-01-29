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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/edit-profile")
    public ResponseEntity<BaseResponse<String>> editProfile(@AuthenticationPrincipal User user, @RequestBody User newUser) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(authService.editProfile(user, newUser)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.EDIT_PROFILE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<String>> me(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(BaseResponse.ok(user));
    }

    @GetMapping("/change-password")
    public ResponseEntity<BaseResponse<String>> changePassword(@AuthenticationPrincipal User user, String newPassword) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(authService.changePassword(user, newPassword)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CHANGE_PASSWORD + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
