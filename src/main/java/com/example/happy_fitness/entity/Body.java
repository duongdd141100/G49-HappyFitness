package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "body")
public class Body extends BaseEntity{
    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "chest")
    private Integer chest;

    @Column(name = "waist")
    private Integer waist;

    @Column(name = "hip")
    private Integer hip;

    @Column(name = "exercise")
    private String exercise;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
