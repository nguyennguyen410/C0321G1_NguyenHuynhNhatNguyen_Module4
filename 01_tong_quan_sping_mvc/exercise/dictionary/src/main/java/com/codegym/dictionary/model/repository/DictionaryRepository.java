package com.codegym.dictionary.model.repository;

import java.util.Map;

public interface DictionaryRepository {
    Map<String, String> findAll();
}
