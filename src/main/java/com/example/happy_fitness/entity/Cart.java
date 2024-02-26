package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carts")
@SqlResultSetMapping(
        name = "CartDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.CartDto.class,
                columns = {
                        @ColumnResult(name = "facilityProductId", type = Float.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "image", type = String.class),
                        @ColumnResult(name = "category", type = String.class),
                        @ColumnResult(name = "supplier", type = String.class),
                        @ColumnResult(name = "price", type = Float.class),
                        @ColumnResult(name = "quantity", type = Integer.class),
                }
        )
)
public class Cart extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "facility_product_id")
    private FacilityProduct facilityProduct;

    @Column(name = "quantity")
    private Integer quantity;
}
