package com.codegym.model.service;

import com.codegym.model.entity.Position;
import com.codegym.model.entity.RentType;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
