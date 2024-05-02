package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "attendance")
public class Attendance extends BaseEntity {
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "class_student_id")
    private ClassStudent classStudent;

    @ManyToOne
    @JoinColumn(name = "train_history_id")
    private TrainHistory trainHistory;
}
