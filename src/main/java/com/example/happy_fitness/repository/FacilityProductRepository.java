package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityProductRepository extends JpaRepository<FacilityProduct, Float> {
    List<FacilityProduct> findAllByProduct_Id(Float productId);
}
