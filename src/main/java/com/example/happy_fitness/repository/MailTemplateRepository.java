package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailTemplateRepository extends JpaRepository<MailTemplate, Long> {
    MailTemplate findByCode(String code);
}
