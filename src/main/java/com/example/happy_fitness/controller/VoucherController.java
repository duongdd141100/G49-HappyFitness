package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Voucher;
import com.example.happy_fitness.service.VoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vouchers")
@Slf4j
@CrossOrigin
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<String>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(voucherService.findAll()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_VOUCHERS + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> create(@AuthenticationPrincipal UserDetails userDetails,
                                                       @RequestBody Voucher voucher) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(voucherService.create(userDetails, voucher)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_VOUCHERS + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> update(@PathVariable Long id,
                                                       @RequestBody Voucher voucher,
                                                       @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(voucherService.update(voucher, id, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_VOUCHERS + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
