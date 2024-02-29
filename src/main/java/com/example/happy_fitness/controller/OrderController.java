package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<String>> order(@RequestBody List<Float> cartIds,
                                                      @RequestParam(required = false) String voucherCode) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderService.order(cartIds, voucherCode)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.ORDER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_CUSTOMER', 'ROLE_RECEPTIONIST')")
    public ResponseEntity<BaseResponse<String>> findOrders(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderService.findOrders(userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.VIEW_ORDER + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_CUSTOMER', 'ROLE_RECEPTIONIST')")
    public ResponseEntity<BaseResponse<String>> findOrderDetail(@PathVariable Float id,
                                                                @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderService.findOrderDetail(id, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.VIEW_ORDER_DETAIL + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
