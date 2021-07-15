package com.codegym.calculator_simple.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorSimpleServiceImpl implements CalculatorSimpleService {

    @Override
    public float calculator(float firstParameter, float secondParameter, String operator) {
        float result;
        switch (operator) {
            case ("Addition(+)"):
                result = firstParameter + secondParameter;
                break;
            case ("Subtraction(-)"):
                result = firstParameter - secondParameter;
                break;
            case ("Multiplication(*)"):
                result = firstParameter * secondParameter;
                break;
            case ("Division(/)"):
                result = firstParameter / secondParameter;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
