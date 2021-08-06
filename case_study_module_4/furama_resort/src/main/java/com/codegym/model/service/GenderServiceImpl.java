package com.codegym.model.service;

import com.codegym.model.entity.Gender;
import com.codegym.model.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    GenderRepository genderRepository;
    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }
}
