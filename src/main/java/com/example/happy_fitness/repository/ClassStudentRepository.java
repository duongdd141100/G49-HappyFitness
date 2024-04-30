package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.ClassStudent;
import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudent, Long> {
    List<ClassStudent> findAllByStudent(User student);
}
