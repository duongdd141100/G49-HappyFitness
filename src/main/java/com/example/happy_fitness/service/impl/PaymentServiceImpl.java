package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.entity.CustomerTicket;
import com.example.happy_fitness.entity.Order;
import com.example.happy_fitness.repository.CustomerTicketRepository;
import com.example.happy_fitness.repository.OrderRepository;
import com.example.happy_fitness.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerTicketRepository customerTicketRepo;

    @Override
    public String updateInfo(String code, Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.ORDER_NOT_EXIST.getCode()));
        if ("00".equals(code)) {
            order.setPaid(true);
        }
        orderRepo.save(order);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String updateTicketInfo(String responseCode, Long ticketId) {
        CustomerTicket customerTicket = customerTicketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.ORDER_NOT_EXIST.getCode()));
        if ("00".equals(responseCode)) {
            customerTicket.setPaid(true);
            customerTicket.setStatus(true);
        }
        customerTicketRepo.save(customerTicket);
        return HttpStatus.OK.getReasonPhrase();
    }
}
