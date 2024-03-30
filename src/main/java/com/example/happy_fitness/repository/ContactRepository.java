package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Facility, Long> {

}
