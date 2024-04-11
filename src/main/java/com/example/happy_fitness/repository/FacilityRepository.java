package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FacilityRepository extends JpaRepository<Facility, BigInteger> {
}
