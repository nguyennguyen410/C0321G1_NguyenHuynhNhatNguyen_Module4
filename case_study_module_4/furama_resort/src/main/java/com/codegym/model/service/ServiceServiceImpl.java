package com.codegym.model.service;

import com.codegym.model.entity.Service;
import com.codegym.model.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Optional<Service> findById(String serviceId) {
        return serviceRepository.findById(serviceId);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }
}
