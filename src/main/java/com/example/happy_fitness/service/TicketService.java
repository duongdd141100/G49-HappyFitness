package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Ticket;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TicketService extends BaseService<Ticket> {
    List<Ticket> findAllByFacilityId(Long facilityId);

    Ticket findTicketDetail(Long id);

    String deactivate(UserDetails userDetails, Long id);

    String active(UserDetails userDetails, Long id);
}
