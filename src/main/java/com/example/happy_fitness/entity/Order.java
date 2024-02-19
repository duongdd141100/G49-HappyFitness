package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
@SqlResultSetMapping(
        name = "RevenueDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.RevenueDto.class,
                columns = {
                        @ColumnResult(name = "month", type = Integer.class),
                        @ColumnResult(name = "year", type = Integer.class),
                        @ColumnResult(name = "revenue", type = Float.class),
                }
        )
)
@SqlResultSetMapping(
        name = "DashboardInfoDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.DashboardInfoDto.class,
                columns = {
                        @ColumnResult(name = "totalSale", type = Float.class),
                        @ColumnResult(name = "productSold", type = Integer.class),
                        @ColumnResult(name = "totalOrder", type = Integer.class),
                        @ColumnResult(name = "newCustomer", type = Integer.class),
                }
        )
)
public class Order extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @Column(name = "status")
    private String status;
}
