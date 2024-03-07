package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Ticket;
import com.example.happy_fitness.service.CustomerTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-ticket")
@Slf4j
public class UserTicketController {
    @Autowired
    private CustomerTicketService customerTicketService;

    @PostMapping("/extend/{id}")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<Ticket>> create(@PathVariable Float id,
                                                       @RequestParam(required = false) String voucherCode) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(customerTicketService.extend(id, voucherCode)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.EXTEND_TICKET + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
