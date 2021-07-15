package com.codegym.calculator_simple.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorSimpleServiceImpl implements CalculatorSimpleService {

    @Override
    public float calculator(float textA, float textB, String operator) {
        float result;
        switch (operator) {
            case ("Addition(+)"):
                result = textA + textB;
                break;
            case ("Subtraction(-)"):
                result = textA - textB;
                break;
            case ("Multiplication(*)"):
                result = textA * textB;
                break;
            case ("Division(/)"):
                result = textA / textB;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
