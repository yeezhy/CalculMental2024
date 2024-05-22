package com.example.calculatriceg1java;

public enum TypeOperation {
    ADD("+"),
    SUBSTRAST("-"),
    DIVIDE("/"),
    MULTIPLY("x");

    private String symbole;


    TypeOperation(String symbole) {
        this.symbole=symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
