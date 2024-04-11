package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MailTemplateRepository extends JpaRepository<MailTemplate, BigInteger> {
    MailTemplate findByCode(String code);
}
