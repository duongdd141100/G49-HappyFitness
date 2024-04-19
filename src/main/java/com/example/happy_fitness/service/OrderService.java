package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.OrderDetailDto;
import com.example.happy_fitness.dto.OrderDto;
import com.example.happy_fitness.entity.Order;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    Order order(List<Long> carts, String voucherCode);

    List<OrderDto> findOrders(UserDetails userDetails, Boolean isPaid, Boolean isDelivered, Long facilityId);

    List<OrderDetailDto> findOrderDetail(Long id, UserDetails userDetails);
}
