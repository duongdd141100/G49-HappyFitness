package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "train_schedule")
public class TrainSchedule extends BaseEntity {
    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "train_time_id")
    private TrainTime trainTime;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;
}
