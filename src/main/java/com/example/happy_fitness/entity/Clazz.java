package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "classes")
public class Clazz extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "remain_slot")
    private Integer remainSlot;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private User pt;
}
