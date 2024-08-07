package com.example.blogRestAPI.service;

import com.example.blogRestAPI.dto.BlogDTO;
import com.example.blogRestAPI.entity.BlogPost;
import com.example.blogRestAPI.entity.User;
import com.example.blogRestAPI.exception.ResourceNotFoundException;
import com.example.blogRestAPI.repository.BlogRepository;
import com.example.blogRestAPI.repository.UserRepository;
import com.example.blogRestAPI.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<BlogPost> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        BlogPost blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
        return convertToDTO(blog);
    }

    @Override
    @Transactional
    public BlogDTO createBlog(BlogDTO blogDto) {
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userPrinciple.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        BlogPost blog = new BlogPost();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        blog.setUser(user);

        BlogPost savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    @Override
    @Transactional
    public BlogDTO updateBlog(Long id, BlogDTO blogDto) {
        BlogPost blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));

        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!blog.getUser().getId().equals(userPrinciple.getId())) {
            throw new IllegalStateException("You are not authorized to update this blog");
        }

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setUpdatedAt(LocalDateTime.now());

        BlogPost updatedBlog = blogRepository.save(blog);
        return convertToDTO(updatedBlog);
    }

    @Override
    @Transactional
    public void deleteBlog(Long id) {
        BlogPost blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));

        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!blog.getUser().getId().equals(userPrinciple.getId())) {
            throw new IllegalStateException("You are not authorized to delete this blog");
        }

        blogRepository.delete(blog);
    }

    private BlogDTO convertToDTO(BlogPost blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setCreatedAt(blog.getCreatedAt());
        dto.setUpdatedAt(blog.getUpdatedAt());
        dto.setUserId(blog.getUser().getId());
        return dto;
    }
}