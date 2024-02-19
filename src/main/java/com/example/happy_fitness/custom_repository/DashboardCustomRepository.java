package com.example.happy_fitness.custom_repository;

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
            "        user_tickets" +
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

    public List<RevenueDto> getLast12MonthRevenue() {
        Query query = entityManager.createNativeQuery(REVENUE_SQL, "RevenueDto");
        return query.getResultList();
    }
}
