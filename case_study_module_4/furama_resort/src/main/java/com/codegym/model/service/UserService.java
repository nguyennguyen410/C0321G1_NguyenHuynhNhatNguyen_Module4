package com.codegym.model.service;

import com.codegym.model.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
