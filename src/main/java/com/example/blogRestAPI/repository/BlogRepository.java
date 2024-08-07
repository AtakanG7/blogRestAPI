package com.example.blogRestAPI.repository;

import com.example.blogRestAPI.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByUserId(Long userId);
}