package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
@SqlResultSetMapping(
        name = "OrderDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.OrderDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "voucherCode", type = String.class),
                        @ColumnResult(name = "voucherName", type = String.class),
                        @ColumnResult(name = "totalPrice", type = Float.class),
                        @ColumnResult(name = "discount", type = Float.class),
                        @ColumnResult(name = "price", type = Float.class),
                        @ColumnResult(name = "paid", type = Boolean.class),
                }
        )
)
public class Order extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private Float price;

    @Column(name = "paid")
    private Boolean paid;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;
}
