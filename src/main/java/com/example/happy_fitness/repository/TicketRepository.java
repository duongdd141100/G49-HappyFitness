package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, BigInteger> {
    List<Ticket> findAllByFacility_Id(BigInteger facilityId);
}
