package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "train_history")
public class TrainHistory extends BaseEntity {
    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "train_date")
    private LocalDate trainDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;

    @ManyToOne
    @JoinColumn(name = "train_time_id")
    private TrainTime trainTime;
}
