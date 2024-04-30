package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.BookingRequestBodyDto;

public interface PaymentService {
    String updateOrderInfo(String code, Long orderId);

    String updateTicketInfo(String responseCode, Long ticketId);

    String createSchedule(String responseCode, BookingRequestBodyDto bookingRequestBodyDto);
}
