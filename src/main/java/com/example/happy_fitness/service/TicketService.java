package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Ticket;

import java.util.List;

public interface TicketService extends BaseService<Ticket> {
    List<Ticket> findAllByFacilityId(Float facilityId);
}
