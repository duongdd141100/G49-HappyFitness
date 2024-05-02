package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "classes")
public class Clazz extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private User pt;

    @OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY)
    private List<ClassStudent> classStudents;

    @OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY)
    private List<TrainSchedule> trainSchedules;
}
