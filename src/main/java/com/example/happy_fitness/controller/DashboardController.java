package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.RevenueDto;
import com.example.happy_fitness.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@Slf4j
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/revenue")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<List<RevenueDto>>> getLast12MonthsRevenue() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(dashboardService.getLast12MonthRevenue()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.REVENUE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
