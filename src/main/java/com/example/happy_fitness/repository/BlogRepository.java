package net.blog.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.blog.springboot.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
