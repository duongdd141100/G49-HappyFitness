package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_pt")
public class CustomerPt extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private User pt;

    @Column(name = "slots_total")
    private Integer slotsTotal;

    @Column(name = "slots_remaining")
    private Integer slotsRemaining;

    @Column(name = "price")
    private Float price;

    @Column(name = "note")
    private String note;
}
