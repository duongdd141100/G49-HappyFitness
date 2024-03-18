package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.CustomerTicket;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomerTicketService extends BaseService<CustomerTicket> {
    String extend(Float id, String voucherCode);

    String buy(Float id, String voucherCode, UserDetails userDetails);
}
