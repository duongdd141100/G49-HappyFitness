package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Float> {
    Optional<Voucher> findByCode(String code);
}
