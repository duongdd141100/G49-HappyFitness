package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CartRepository extends JpaRepository<Cart, BigInteger> {
    Cart findByCreatedByAndFacilityProduct_Id(String username, BigInteger facilityProductId);
}
