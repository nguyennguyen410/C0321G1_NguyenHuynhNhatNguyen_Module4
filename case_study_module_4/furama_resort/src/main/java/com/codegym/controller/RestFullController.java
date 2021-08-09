package com.codegym.controller;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;
import com.codegym.model.service.AttachServiceService;
import com.codegym.model.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
public class RestFullController {
    @Autowired
    ContractService contractService;

    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping("/contractId/{id}")
    public ResponseEntity<Contract> findContract(@PathVariable String id) {
        Optional<Contract> contract = contractService.findById(id);
        if (!contract.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contract.get(), HttpStatus.OK);
    }

    @GetMapping("/attachServiceId/{id}")
    public ResponseEntity<AttachService> findAttachService(@PathVariable String id) {
        Optional<AttachService> attachServices = attachServiceService.findById(id);
        if (!attachServices.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachServices.get(), HttpStatus.OK);
    }

}
