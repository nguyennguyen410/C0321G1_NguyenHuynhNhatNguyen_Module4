package com.codegym.model.repository;

import com.codegym.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
