package com.example.calculatorTesting.service;


import org.springframework.stereotype.Service;


@Service

public class CalculatorService {


    public int getSummary(Integer num1, Integer num2) {

        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров не передан");
        }
        return (num1 + num2);
    }


    public int getSubtraction(Integer num1, Integer num2) {

        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров не передан");
        }
        return num1 - num2;
    }


    public int getMultiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров не передан");
        }
        return num1 * num2;
    }


    public int getDivision(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров не передан");
        }
        return num1 / num2;
    }
}
