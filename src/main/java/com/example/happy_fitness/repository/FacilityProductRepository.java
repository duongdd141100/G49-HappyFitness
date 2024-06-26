package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityProductRepository extends JpaRepository<FacilityProduct, Long> {
    List<FacilityProduct> findAllByProduct_Id(Long productId);
    FacilityProduct findByFacility_IdAndProduct_Id(Long facilityId, Long productId);
}
