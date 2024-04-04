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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@Slf4j
@CrossOrigin
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

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Ticket>>> findTickets(@RequestParam Float facilityId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(ticketService.findAllByFacilityId(facilityId)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_TICKET + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<List<Ticket>>> findTicketDetail(@PathVariable Float id) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(ticketService.findTicketDetail(id)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_TICKET_DETAIL + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/deactivate/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<BaseResponse<List<Ticket>>> findTicketDetail(@PathVariable Float id,
                                                                       @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(ticketService.deactivate(userDetails, id)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_TICKET_DETAIL + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BaseResponse<String>> update(@PathVariable Float id, @RequestBody Ticket ticket) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(ticketService.update(ticket, id, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_TICKET_DETAIL + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
