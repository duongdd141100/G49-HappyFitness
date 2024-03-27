package src.main.java.com.example.happy_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.blog.springboot.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
