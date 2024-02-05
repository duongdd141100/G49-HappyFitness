package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carts")
public class Cart extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "facility_product_id")
    private FacilityProduct facilityProduct;

    @Column(name = "quantity")
    private Integer quantity;
}
