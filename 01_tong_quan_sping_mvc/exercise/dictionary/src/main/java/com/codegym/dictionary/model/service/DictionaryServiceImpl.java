package com.codegym.dictionary.model.service;

import com.codegym.dictionary.model.repository.DictionaryRepository;
import com.codegym.dictionary.model.repository.DictionaryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Autowired
    DictionaryRepositoryImpl dictionaryRepository;
    @Override
    public Map<String, String> findAll() {
        return dictionaryRepository.findAll();
    }
}
