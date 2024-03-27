package src.main.java.com.example.happy_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.blog.springboot.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

}
