package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.UserDto;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<List<UserDto>>> findUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean gender,
            @RequestParam(required = false) Float roleId,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(userService.findAllByCondition(userDetails.getUsername(), username, fullName, email, gender, roleId)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_USER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<UserDto>> createUser(@RequestBody User user,
                                                            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(userService.create(userDetails.getUsername(), user)));
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.unAuthentication(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CREATE_USER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/{username}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<UserDto>> findUserDetail(@PathVariable String username,
                                                            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(userService.findUserDetail(userDetails, username)));
        } catch (AccessDeniedException e) {
            log.error(RequestMappingConstant.CREATE_USER + e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.unAuthentication(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CREATE_USER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
