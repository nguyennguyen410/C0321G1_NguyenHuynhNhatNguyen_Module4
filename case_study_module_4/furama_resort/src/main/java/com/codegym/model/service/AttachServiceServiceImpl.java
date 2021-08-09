package com.codegym.model.service;

import com.codegym.model.entity.AttachService;
import com.codegym.model.repository.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachServiceServiceImpl implements AttachServiceService{
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(String id) {
        return attachServiceRepository.findById(id);
    }
}
