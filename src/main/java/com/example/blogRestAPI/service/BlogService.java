package com.example.blogRestAPI.service;

import com.example.blogRestAPI.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    List<BlogDTO> getAllBlogs();
    BlogDTO getBlogById(Long id);
    BlogDTO createBlog(BlogDTO blogDto);
    BlogDTO updateBlog(Long id, BlogDTO blogDto);
    void deleteBlog(Long id);
}