package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.CustomerTicket;
import com.example.happy_fitness.entity.Ticket;
import com.example.happy_fitness.service.CustomerTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-ticket")
@Slf4j
@CrossOrigin
public class UserTicketController {
    @Autowired
    private CustomerTicketService customerTicketService;

    @PostMapping("/extend/{id}")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<CustomerTicket>> extend(@PathVariable Long id,
                                                       @RequestParam(required = false) String voucherCode) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(customerTicketService.extend(id, voucherCode)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.EXTEND_TICKET + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/buy/{id}")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<CustomerTicket>> buy(@PathVariable Long id,
                                                            @RequestParam(required = false) String voucherCode,
                                                            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(customerTicketService.buy(id, voucherCode, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.BUY_TICKET + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_RECEPTIONIST')")
    public ResponseEntity<BaseResponse<CustomerTicket>> findAll(@AuthenticationPrincipal UserDetails userDetails,
                                                                @RequestParam(required = false) Long facilityId,
                                                                @RequestParam(required = false) Boolean isActive,
                                                                @RequestParam(required = false) Boolean isUsing) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(customerTicketService.findByUsername(userDetails, facilityId, isActive, isUsing)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.TICKET_HISTORY + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/using/{customerUsername}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_RECEPTIONIST')")
    public ResponseEntity<BaseResponse<String>> using(@PathVariable String customerUsername) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(customerTicketService.using(customerUsername)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CHANGE_CUSTOMER_TICKET_USING + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
