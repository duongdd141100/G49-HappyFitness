package com.example.happy_fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "about")
public class About extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;
}
