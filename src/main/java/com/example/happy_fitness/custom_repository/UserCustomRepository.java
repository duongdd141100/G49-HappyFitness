package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class UserCustomRepository {

    @Autowired
    private EntityManager entityManager;

    private final String BASE_QUERY = "SELECT" +
            "    u.id," +
            "    u.username," +
            "    u.full_name AS fullName," +
            "    u.email," +
            "    u.gender," +
            "    u.dob," +
            "    u.phone_number AS phoneNumber," +
            "    u.address," +
            "    r.name AS roleName" +
            " FROM" +
            "    users u" +
            "        INNER JOIN" +
            "    roles r ON u.role_id = r.id";

    public List<User> findAllByCondition(String username, String fullName, String email, Boolean gender, Float roleId) {
        String sql = BASE_QUERY + getCondition(username, fullName, email, gender, roleId);
        Query query = entityManager.createNativeQuery(sql, "UserDto");
        if (StringUtils.hasText(username)) {
            query.setParameter("username", "%" + username + "%");
        }
        if (StringUtils.hasText(fullName)) {
            query.setParameter("fullName", "%" + fullName + "%");
        }
        if (StringUtils.hasText(email)) {
            query.setParameter("email", "%" + email + "%");
        }
        if (gender != null) {
            query.setParameter("gender", gender);
        }
        if (roleId != null) {
            query.setParameter("roleId", roleId);
        }
        return query.getResultList();
    }

    private String getCondition(String username, String fullName, String email, Boolean gender, Float roleId) {
        String condition = "";
        if (StringUtils.hasText(username)) {
            condition += " AND u.username LIKE :username";
        }
        if (StringUtils.hasText(fullName)) {
            condition += " AND u.full_name LIKE :fullName";
        }
        if (StringUtils.hasText(email)) {
            condition += " AND u.email LIKE :email";
        }
        if (gender != null) {
            condition += " AND u.gender = :gender";
        }
        if (roleId != null) {
            condition += " AND r.id = :roleId";
        }
        return StringUtils.hasText(condition) ? " WHERE" + condition.substring(4) : "";
    }
}
