package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
}
