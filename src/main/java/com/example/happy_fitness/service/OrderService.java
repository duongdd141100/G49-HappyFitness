package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.OrderDto;
import com.example.happy_fitness.entity.Order;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    String order(List<Float> carts, String voucherCode);

    List<OrderDto> findOrders(UserDetails userDetails);
}
