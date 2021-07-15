package com.codegym.spices_for_sandwich.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpicesSandwichServiceImpl implements SpicesSandwichService{

    @Override
    public List<String> displaySpices(String[] spices) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<spices.length; i++){
            list.add(spices[i]);
        }
        return list;
    }
}
