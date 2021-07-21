package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(Blog blog);
}
