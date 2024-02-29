package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Ticket;
import com.example.happy_fitness.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<Ticket>> create(@RequestBody Ticket ticket,
                                                       @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(ticketService.create(userDetails, ticket)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CREATE_TICKET + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
