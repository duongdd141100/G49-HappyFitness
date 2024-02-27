package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.CartDto;
import com.example.happy_fitness.entity.Cart;

import java.util.List;

public interface CartService extends BaseService<Cart> {
    List<CartDto> findAllByUser(String username);

    String addToCart(String username, Cart cart);

    String changeQuantity(List<CartDto> carts);
}
