package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer_pt_history")
public class CustomerPtHistory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customer_pt_id")
    private CustomerPt customerPt;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;
}
