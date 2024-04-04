package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.dto.ProductDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class ProductCustomRepository {
    @Autowired
    private EntityManager entityManager;

    private final String GET_PRODUCT_QUERY = " SELECT " +
            "    p.id AS productId," +
            "    fp.id as facilityProductId," +
            "    p.code," +
            "    p.name," +
            "    p.image_path AS imagePath," +
            "    c.name AS category," +
            "    s.name AS supplier," +
            "    fp.price," +
            "    f.name as facility," +
            "    fp.status," +
            "    fp.stock_quantity AS stockQuantity" +
            " FROM" +
            "    facility_product fp" +
            "        INNER JOIN" +
            "    products p ON fp.product_id = p.id" +
            "        INNER JOIN" +
            "    suppliers s ON p.supplier_id = s.id" +
            "        INNER JOIN" +
            "    categories c ON c.id = p.category_id" +
            "        INNER JOIN" +
            "    facilities f ON f.id = fp.facility_id";

    public List<ProductDto> findProduct(Float facilityId, String status, Float categoryId, Float supplierId, Float minPrice, Float maxPrice) {
        String sql = GET_PRODUCT_QUERY + getCondition(status, categoryId, supplierId, minPrice, maxPrice);
        Query query = entityManager.createNativeQuery(sql, "ProductDto");
        query.setParameter("facilityId", facilityId);
        if (StringUtils.hasText(status)) {
            query.setParameter("facilityId", facilityId);
        }
        if (StringUtils.hasText(status)) {
            query.setParameter("status", status);
        }
        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (supplierId != null) {
            query.setParameter("supplierId", supplierId);
        }
        if (minPrice != null) {
            query.setParameter("minPrice", minPrice);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        return query.getResultList();
    }

    private String getCondition(String status, Float categoryId, Float supplierId, Float minPrice, Float maxPrice) {
        String condition = " WHERE f.id = :facilityId";
        if (StringUtils.hasText(status)) {
            condition += " AND fp.status = :status";
        }
        if (StringUtils.hasText(status)) {
            condition += " AND fp.status = :status";
        }
        if (categoryId != null) {
            condition += " AND c.id = :categoryId";
        }
        if (supplierId != null) {
            condition += " AND s.id = :supplierId";
        }
        if (minPrice != null) {
            condition += " AND fp.price >= :minPrice";
        }
        if (maxPrice != null) {
            condition += " AND fp.price <= :maxPrice";
        }
        return condition;
    }

    public ProductDto findProductDetail(Float facilityId, String code) {
        String sql = GET_PRODUCT_QUERY + " WHERE p.code = :code AND f.id = :facilityId";
        Query query = entityManager.createNativeQuery(sql, "ProductDto");
        query.setParameter("code", code);
        query.setParameter("facilityId", facilityId);
        return (ProductDto) ((NativeQueryImpl) query).getSingleResultOrNull();
    }
}
