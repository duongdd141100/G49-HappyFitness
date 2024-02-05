package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "facilities")
public class Facility extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "work_start_time")
    private Date workStartTime;

    @Column(name = "work_end_time")
    private Date workEndTime;

    @Column(name = "hotline")
    private String hotline;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private User manager;
}
