package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.custom_repository.CartCustomRepository;
import com.example.happy_fitness.dto.CartDto;
import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.repository.CartRepository;
import com.example.happy_fitness.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private CartCustomRepository cartCustomRepo;

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

    @Override
    public List<CartDto> findAllByUser(String username) {
        return cartCustomRepo.findAllByUser(username);
    }
}
