package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RoleRepository extends JpaRepository<Role, BigInteger> {
}
