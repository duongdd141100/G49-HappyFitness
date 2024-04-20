package com.example.happy_fitness.service;

public interface PaymentService {
    String updateInfo(String code, Long orderId);

    String updateTicketInfo(String responseCode, Long ticketId);
}
