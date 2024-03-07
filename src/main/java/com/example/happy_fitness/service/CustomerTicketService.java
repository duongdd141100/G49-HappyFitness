package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.CustomerTicket;

public interface CustomerTicketService extends BaseService<CustomerTicket> {
    String extend(Float id, String voucherCode);
}
