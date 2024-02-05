package com.example.happy_fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    @Column(name = "name")
    private String name;
}
