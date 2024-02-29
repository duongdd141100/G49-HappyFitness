package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@SqlResultSetMapping(
        name = "OrderDetailDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.OrderDetailDto.class,
                columns = {
                        @ColumnResult(name = "productCode", type = String.class),
                        @ColumnResult(name = "productName", type = String.class),
                        @ColumnResult(name = "image", type = String.class),
                        @ColumnResult(name = "unitPrice", type = Float.class),
                        @ColumnResult(name = "quantity", type = Integer.class),
                        @ColumnResult(name = "facility", type = String.class),
                }
        )
)
@Entity
@Data
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "facility_product_id")
    private FacilityProduct facilityProduct;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note")
    private String note;
}
