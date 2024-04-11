package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.CustomerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, BigInteger> {
    List<CustomerTicket> findAllByStatusIsTrue();

    List<CustomerTicket> findAllByCustomer_IdAndStatusIsTrue(BigInteger customerId);

    List<CustomerTicket> findAllByCustomer_UsernameOrderByUpdatedDateDesc(String username);
}
