package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.entity.Order;
import com.example.happy_fitness.repository.OrderRepository;
import com.example.happy_fitness.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private OrderRepository orderRepo;

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
}
