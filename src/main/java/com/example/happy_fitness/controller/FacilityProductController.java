package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.FacilityProduct;
import com.example.happy_fitness.service.FacilityProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facility-product")
@Slf4j
public class FacilityProductController {
    @Autowired
    private FacilityProductService facilityProductService;

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<String>> order(@PathVariable Float id,
                                                      @RequestBody FacilityProduct facilityProduct) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(facilityProductService.update(facilityProduct, id)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_FACILITY_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
