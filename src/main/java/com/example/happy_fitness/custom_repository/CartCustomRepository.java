package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.dto.CartDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartCustomRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    private final String GET_CART_SQL = "SELECT " +
            "    fp.id AS facilityProductId," +
            "    p.code," +
            "    p.name," +
            "    p.image_path AS image," +
            "    cat.name AS category," +
            "    s.name AS supplier," +
            "    fp.price," +
            "    c.quantity" +
            " FROM" +
            "    carts c" +
            "        INNER JOIN" +
            "    facility_product fp ON c.facility_product_id = fp.id" +
            "        INNER JOIN" +
            "    products p ON fp.product_id = p.id" +
            "        INNER JOIN" +
            "    categories cat ON cat.id = p.category_id" +
            "        INNER JOIN" +
            "    suppliers s ON s.id = p.supplier_id" +
            " WHERE" +
            "    c.created_by = :username";
    
    public List<CartDto> findAllByUser(String username) {
        Query query = entityManager.createNativeQuery(GET_CART_SQL, "CartDto");
        query.setParameter("username", username);
        return query.getResultList();
    }
}
