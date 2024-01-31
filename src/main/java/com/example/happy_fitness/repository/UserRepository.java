package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Float>  {
    User findByUsername(String username);

    Boolean existsByEmail(String email);
}
