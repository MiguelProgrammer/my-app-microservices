package br.com.estudandoemcasa.services;

import br.com.estudandoemcasa.entity.Calculator;
import br.com.estudandoemcasa.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MathServices {

    public Double sum(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.sum(numberOne, numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.substraction(numberOne, numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.division(numberOne, numberTwo);
    }

    public Double times(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.times(numberOne, numberTwo);
    }

    public Double media(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.media(numberOne, numberTwo);
    }

    public String squareRoot(String numberOne, String numberTwo) {
        Calculator calculator = new Calculator(numberOne, numberTwo);
        return calculator.squareRoot(numberOne, numberTwo);
    }

}
