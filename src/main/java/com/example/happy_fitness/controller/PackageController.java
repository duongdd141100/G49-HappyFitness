package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Package;
import com.example.happy_fitness.service.PackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@Slf4j
@CrossOrigin
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Package>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(packageService.findAll()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_PACKAGE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<List<Package>>> create(@RequestBody Package aPackage,
                                                              @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(packageService.create(userDetails, aPackage)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CREATE_PACKAGE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BaseResponse<List<Package>>> update(@RequestBody Package aPackage,
                                                              @PathVariable Long id,
                                                              @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(packageService.update(aPackage, id, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CREATE_PACKAGE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
