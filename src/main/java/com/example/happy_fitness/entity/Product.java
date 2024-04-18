package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "products")
@SqlResultSetMapping(
        name = "ProductDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.ProductDto.class,
                columns = {
                        @ColumnResult(name = "productId", type = Long.class),
                        @ColumnResult(name = "facilityProductId", type = Long.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "imagePath", type = String.class),
                        @ColumnResult(name = "categoryId", type = Long.class),
                        @ColumnResult(name = "category", type = String.class),
                        @ColumnResult(name = "supplierId", type = Long.class),
                        @ColumnResult(name = "supplier", type = String.class),
                        @ColumnResult(name = "price", type = Float.class),
                        @ColumnResult(name = "facilityId", type = Long.class),
                        @ColumnResult(name = "facility", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "stockQuantity", type = Integer.class),
                        @ColumnResult(name = "description", type = String.class),
                }
        )
)
public class Product extends BaseEntity {
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FacilityProduct> facilityProducts;
}
