package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityProductRepository extends JpaRepository<FacilityProduct, Float> {
}
