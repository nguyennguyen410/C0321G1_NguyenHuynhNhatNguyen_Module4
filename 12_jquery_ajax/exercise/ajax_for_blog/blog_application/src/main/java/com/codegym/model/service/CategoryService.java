package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void delete(Category category);
}
