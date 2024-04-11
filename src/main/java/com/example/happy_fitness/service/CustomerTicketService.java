package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.CustomerTicket;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.List;

public interface CustomerTicketService extends BaseService<CustomerTicket> {
    String extend(BigInteger id, String voucherCode);

    String buy(BigInteger id, String voucherCode, UserDetails userDetails);

    List<CustomerTicket> findByUsername(String username);
}
