package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "train_fee")
public class TrainFee extends BaseEntity {
    @Column(name = "price")
    private Float price;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
}
