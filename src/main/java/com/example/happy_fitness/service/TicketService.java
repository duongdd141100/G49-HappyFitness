package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Ticket;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.List;

public interface TicketService extends BaseService<Ticket> {
    List<Ticket> findAllByFacilityId(BigInteger facilityId);

    Ticket findTicketDetail(BigInteger id);

    String deactivate(UserDetails userDetails, BigInteger id);
}
