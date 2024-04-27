package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    User findByUsername(String username);

    Boolean existsByEmail(String email);

    List<User> findAllByStatusIsTrueAndRole_Id(Long roleId);

    List<User> findAllByRole_IdAndFacility_Id(Long roleId, Long facilityId);
}
