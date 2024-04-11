package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger>  {
    User findByUsername(String username);

    Boolean existsByEmail(String email);

    List<User> findAllByStatusIsTrueAndRole_Id(BigInteger roleId);
}
