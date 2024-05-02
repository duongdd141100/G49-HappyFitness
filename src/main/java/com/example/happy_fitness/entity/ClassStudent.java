package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "class_student")
public class ClassStudent extends BaseEntity {
    @Column(name = "remain_slot")
    private Integer remainSlot;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;
}
