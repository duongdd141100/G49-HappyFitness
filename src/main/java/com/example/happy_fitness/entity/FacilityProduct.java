package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "facility_product")
public class FacilityProduct extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "status")
    private String status;
}
