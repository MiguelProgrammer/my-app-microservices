package br.com.estudandoemcasa.entity;

import java.io.Serializable;

public class Calculator  extends Function implements Serializable {

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
        System.out.println(this.toString());

        return this.convertDouble(numberOne) + this.convertDouble(numberTwo);
    }

    public Double times(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.operation = "Times";
        System.out.println(this.toString());

        return this.convertDouble(numberOne) * this.convertDouble(numberTwo);
    }

    public Double substraction(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Substraction";
        System.out.println(this.toString());

        return this.convertDouble(numberOne) - this.convertDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Division";
        System.out.println(this.toString());

        return this.convertDouble(numberOne) / this.convertDouble(numberTwo);
    }

    public Double media(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.numberOneValid(numberOne, numberTwo);
        this.operation = "Media";
        System.out.println(this.toString());

        return (this.convertDouble(numberOne) + this.convertDouble(numberTwo)) / 2;
    }

    public String squareRoot(String numberOne, String numberTwo) {

        this.message(numberOne, numberTwo);
        this.numberPositiv(numberOne, numberTwo);
        this.operation = "SquareRoot";
        System.out.println(this.toString());

        return Math.sqrt(this.convertDouble(numberOne)) + " - " + Math.sqrt(this.convertDouble(numberTwo));
    }

    @Override
    public String toString() {
        return " -- Calculator -- \n" +
                "Number One = " + this.numberOne + " & Number Two = " + this.numberTwo +
                "\nOperation: " + this.operation;
    }
}
