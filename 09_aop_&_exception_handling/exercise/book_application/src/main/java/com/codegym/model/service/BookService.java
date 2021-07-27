package com.codegym.model.service;

import com.codegym.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(String id);

    void save(Book book);
}
