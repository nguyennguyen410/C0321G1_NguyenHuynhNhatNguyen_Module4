package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(Blog blog);

    List<Blog> findAllByNameContaining(String name);

    List<Blog> findAllByCategory_Id(Long id);
}