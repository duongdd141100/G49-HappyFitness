package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
}
