package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private User pt;

    @Column(name = "train_date")
    private LocalDate trainDate;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "train_time_id")
    private TrainTime trainTime;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
}
