package com.codegym.model.service;

import com.codegym.model.entity.AttachService;

import java.util.List;
import java.util.Optional;

public interface AttachServiceService {
    List<AttachService> findAll();
    Optional<AttachService> findById(String id);
}
