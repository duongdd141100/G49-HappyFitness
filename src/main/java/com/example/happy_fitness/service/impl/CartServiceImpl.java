package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.repository.CartRepository;
import com.example.happy_fitness.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepo;

    @Override
    public Cart create(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public Cart update(Cart cart, Float id) {
        return null;
    }

    @Override
    public void delete(Float id) {

    }
}
