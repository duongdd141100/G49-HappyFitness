package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suppliers")
@Slf4j
@CrossOrigin
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<String>> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(supplierService.findAll()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_SUPPLIER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
