package com.example.happy_fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mail_template")
public class MailTemplate extends BaseEntity{
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;
}
