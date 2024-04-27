package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.dto.DashboardInfoDto;
import com.example.happy_fitness.dto.RevenueDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DashboardCustomRepository {
    @Autowired
    private EntityManager entityManager;

    private final String REVENUE_SQL = "SELECT" +
            "    month, year, SUM(revenue) AS revenue" +
            " FROM" +
            "    (SELECT " +
            "        MONTH(created_date) AS month," +
            "            YEAR(created_date) AS year," +
            "            SUM(unit_price * quantity) AS revenue" +
            "    FROM" +
            "        order_product" +
            "    GROUP BY month , year UNION SELECT " +
            "        MONTH(start_date) AS month," +
            "            YEAR(start_date) AS year," +
            "            SUM(price) AS revenue" +
            "    FROM" +
            "        customer_ticket" +
            "    GROUP BY month , year UNION SELECT " +
            "        MONTH(created_date) AS month," +
            "            YEAR(created_date) AS year," +
            "            SUM(price) AS revenue" +
            "    FROM" +
            "        customer_pt" +
            "    GROUP BY month , year) tbl" +
            " GROUP BY month , year" +
            " ORDER BY year DESC , month DESC" +
            " LIMIT 12";

    private final String INFO_SQL = "SELECT " +
            "    *" +
            " FROM" +
            "    (SELECT " +
            "        SUM(unit_price * quantity) AS totalSale," +
            "            SUM(quantity) AS productSold," +
            "            COUNT(o.id) AS totalOrder" +
            "    FROM" +
            "        order_product op" +
            "    INNER JOIN orders o ON o.id = op.order_id" +
            "    WHERE" +
            "        TIMESTAMPDIFF(DAY, o.created_date, NOW()) <= 30) t1" +
            "        CROSS JOIN" +
            "    (SELECT " +
            "        COUNT(id) AS newCustomer" +
            "    FROM" +
            "        users" +
            "    WHERE" +
            "        TIMESTAMPDIFF(DAY, created_date, NOW()) <= 30" +
            "            AND role_id = 3) t2";
    public List<RevenueDto> getLast12MonthRevenue() {
        Query query = entityManager.createNativeQuery(REVENUE_SQL, "RevenueDto");
        return query.getResultList();
    }

    public DashboardInfoDto getLast30DaysInfo() {
        Query query = entityManager.createNativeQuery(INFO_SQL, "DashboardInfoDto");
        return (DashboardInfoDto) query.getSingleResult();
    }
}
