package com.codegym.model.repository;

import com.codegym.model.entity.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
