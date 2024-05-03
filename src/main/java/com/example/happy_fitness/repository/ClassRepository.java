package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {
    List<Clazz> findAllByPt_Facility(Facility facility);
    List<Clazz> findAllByPt(User pt);
    List<Clazz> findAllByStatusAndType(String status, String type);
}
