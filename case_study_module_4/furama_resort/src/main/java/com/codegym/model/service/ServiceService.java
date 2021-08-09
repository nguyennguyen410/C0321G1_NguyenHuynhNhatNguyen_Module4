package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    void save(Service service);

    Optional<Service> findById(String serviceId);

    void delete(Service service);
}
