package com.example.happy_fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "packages")
public class Package extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Float price;

    @Column(name = "total_slot")
    private Integer totalSlot;
}
