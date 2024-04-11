package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FacilityProductRepository extends JpaRepository<FacilityProduct, BigInteger> {
    List<FacilityProduct> findAllByProduct_Id(BigInteger productId);
    FacilityProduct findByFacility_IdAndProduct_Id(BigInteger facilityId, BigInteger productId);
}
