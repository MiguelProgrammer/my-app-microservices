package br.com.estudandoemcasa.entity;

import java.io.Serializable;

public class Calculator extends Function implements Serializable {

    private String numberOne;
    private String numberTwo;
    private Function function;
    private String operation;

    public Calculator() { }

    public Calculator(String numberOne, String numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = null;
        this.function = new Function();
    }

    public String getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Function getFunction() {
        return function;
    }

    public Double sum(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.operation = "Sum";
        Double result = this.convertDouble(numberOne) + this.convertDouble(numberTwo);
        System.out.println(this.toString(result));

        return this.convertDouble(numberOne) + this.convertDouble(numberTwo);
    }

    public Double times(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.operation = "Times";
        Double result = this.convertDouble(numberOne) * this.convertDouble(numberTwo);
        System.out.println(this.toString(result));

        return this.convertDouble(numberOne) * this.convertDouble(numberTwo);
    }

    public Double substraction(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Substraction";
        Double result = this.convertDouble(numberOne) - this.convertDouble(numberTwo);
        System.out.println(this.toString(result));

        return this.convertDouble(numberOne) - this.convertDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Division";
        Double result = this.convertDouble(numberOne) / this.convertDouble(numberTwo);
        System.out.println(this.toString(result));

        return this.convertDouble(numberOne) / this.convertDouble(numberTwo);
    }

    public Double media(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Media";
        Double result = (this.convertDouble(numberOne) + this.convertDouble(numberTwo)) / 2;

        System.out.println(this.toString(result, numberOne, numberTwo));

        return (this.convertDouble(numberOne) + this.convertDouble(numberTwo)) / 2;
    }

    public String squareRoot(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.operation = "SquareRoot";
        String result = Math.sqrt(this.convertDouble(numberOne)) + " - " + Math.sqrt(this.convertDouble(numberTwo));
        System.out.println(this.toString(result));

        return result;
    }

    public String toString(Object result) {

        return " \n-- Calculator -- \n" +
                "Number One = " + getNumberOne() + " & Number Two = " + getNumberTwo() +
                "\nOperation: " + this.operation + "\n" +
                "Result = " + result;
    }

    public String toString(Object result, String numberOne, String numberTwo) {

        return " \n-- Calculator -- \n" +
                "Number One = " + numberOne + " & Number Two = " + numberTwo +
                "\nOperation: " + this.operation + "\n" +
                "Result = " + result;
    }
}
