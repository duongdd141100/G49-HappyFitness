package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.dto.OrderDetailDto;
import com.example.happy_fitness.dto.OrderDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderCustomRepository {
    @Autowired
    private EntityManager entityManager;
    
    private final String FIND_ORDER_SQL = "SELECT" +
            "    o.id," +
            "    u.full_name AS username," +
            "    o.status," +
            "    v.code AS voucherCode," +
            "    v.name AS voucherName," +
            "    SUM(op.unit_price * quantity) AS totalPrice," +
            "    SUM(op.unit_price * quantity) - o.price AS discount," +
            "    o.price," +
            "    o.paid" +
            " FROM" +
            "    orders o" +
            "        INNER JOIN" +
            "    order_product op ON o.id = op.order_id" +
            "        LEFT JOIN" +
            "    vouchers v ON v.id = o.voucher_id" +
            "        INNER JOIN" +
            "    users u ON u.username = o.created_by";
    
    private final String FIND_ORDER_BY_MANAGER_SQL = "SELECT" +
            "    o.id," +
            "    u.full_name AS username," +
            "    o.status," +
            "    v.code AS voucherCode," +
            "    v.name AS voucherName," +
            "    SUM(op.unit_price * quantity) AS totalPrice," +
            "    SUM(op.unit_price * quantity) - o.price AS discount," +
            "    o.price," +
            "    o.paid" +
            " FROM" +
            "    orders o" +
            "        INNER JOIN" +
            "    order_product op ON o.id = op.order_id" +
            "        LEFT JOIN" +
            "    vouchers v ON v.id = o.voucher_id" +
            "        INNER JOIN" +
            "    users u ON u.username = o.created_by" +
            " WHERE" +
            "    o.id IN (SELECT DISTINCT" +
            "            o.id" +
            "        FROM" +
            "            users u" +
            "                INNER JOIN" +
            "            facilities f ON f.id = u.facility_id" +
            "                INNER JOIN" +
            "            facility_product fp ON fp.facility_id = f.id" +
            "                INNER JOIN" +
            "            order_product op ON op.facility_product_id = fp.id" +
            "                INNER JOIN" +
            "            orders o ON o.id = op.order_id" +
            "        WHERE" +
            "            u.username = :username)";

    private final String ORDER_DETAIL_SQL = "SELECT DISTINCT" +
            "    p.code AS productCode," +
            "    p.name AS productName," +
            "    p.image_path AS image," +
            "    op.unit_price AS unitPrice," +
            "    op.quantity," +
            "    f.name AS facility" +
            " FROM" +
            "    orders o" +
            "        INNER JOIN" +
            "    order_product op ON op.order_id = o.id" +
            "        INNER JOIN" +
            "    facility_product fp ON fp.id = op.facility_product_id" +
            "        INNER JOIN" +
            "    facilities f ON f.id = fp.facility_id" +
            "        INNER JOIN" +
            "    products p ON p.id = fp.product_id" +
            "        INNER JOIN" +
            "    users u ON u.facility_id = f.id" +
            " WHERE" +
            "    o.id = :orderId";

    public List<OrderDto> findAll(String username, String requesterRole) {
        String sql = getFindOrdersSql(requesterRole) + " GROUP BY o.id , u.full_name";
        Query query = entityManager.createNativeQuery(sql, "OrderDto");
        if (Arrays.asList(RoleEnum.ROLE_CUSTOMER.name(),
                RoleEnum.ROLE_MANAGER.name(),
                RoleEnum.ROLE_RECEPTIONIST.name())
                .contains(requesterRole)) {
            query.setParameter("username", username);
        }
        return query.getResultList();
    }

    private String getFindOrdersSql(String requesterRole) {
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            return FIND_ORDER_SQL;
        } else if (RoleEnum.ROLE_CUSTOMER.name().equals(requesterRole)) {
            return FIND_ORDER_SQL + " WHERE u.username = :username";
        } else {
            return FIND_ORDER_BY_MANAGER_SQL;
        }
    }

    public List<OrderDetailDto> findOrderDetail(Long id, String username, String requesterRole) {
        String sql = Arrays.asList(RoleEnum.ROLE_ADMIN.name(), RoleEnum.ROLE_CUSTOMER.name()).contains(requesterRole)
                ? ORDER_DETAIL_SQL
                : ORDER_DETAIL_SQL + " AND u.username = :username";
        Query query = entityManager.createNativeQuery(sql, "OrderDetailDto");
        query.setParameter("orderId", id);
        if (!Arrays.asList(RoleEnum.ROLE_ADMIN.name(), RoleEnum.ROLE_CUSTOMER.name()).contains(requesterRole)) {
            query.setParameter("username", username);
        }
        return query.getResultList();
    }
}
