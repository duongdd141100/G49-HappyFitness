package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.CustomerTicket;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CustomerTicketService extends BaseService<CustomerTicket> {
    String extend(Long id, String voucherCode);

    CustomerTicket buy(Long id, String voucherCode, UserDetails userDetails);

    List<CustomerTicket> findByUsername(String username);
}
