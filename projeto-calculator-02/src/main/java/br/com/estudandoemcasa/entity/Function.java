package br.com.estudandoemcasa.entity;

import br.com.estudandoemcasa.exception.UnsupportedMathOperationException;

public class Function {

    private String numberOne;
    private String numberTwo;

    public Function() { }

    public Function(String numberOne, String numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
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

    public Double convertDouble(String numberAux) {
        String number = numberAux.replace(",", ".");
        if (isNumeric(number) && numberAux != null) {
            return Double.parseDouble(number);
        }
        return 1D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public boolean numberPositiv(String numberOne, String numberTwo) {

        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        if(Double.parseDouble(this.numberOne) < 0 || Double.parseDouble(this.numberTwo) < 0) {
            throw new UnsupportedMathOperationException("Please, enter with number valid!");
        }
        return true;
    }

    protected boolean numberOneValid(String numberOne, String numberTwo) {

        this.setNumberOne(numberOne);
        this.setNumberOne(numberTwo);

        if (Double.parseDouble(this.numberOne) < Double.parseDouble(this.numberTwo)) {
            throw new UnsupportedMathOperationException("NumberOne invalid or minor than NumberTwo.");
        }
        return true;
    }

    public void message(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, enter with number valid!");
        }
    }
}
