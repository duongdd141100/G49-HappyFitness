package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Order;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    String order(List<Float> carts, String voucherCode);
}
