package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCreatedByAndFacilityProduct_Id(String username, Long facilityProductId);
    List<Cart> findAllByFacilityProductIn(List<FacilityProduct> facilityProducts);
}
