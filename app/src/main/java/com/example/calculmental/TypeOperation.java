package com.example.calculmental;

public enum TypeOperation{

    ADD(" + "),
    SUBSTRACT(" - "),
    MULTIPLY(" * "),
    DIVIDE(" / ");

    TypeOperation(String symbole){
        this.symbole = symbole;
    }
    public String getSymbole(){
        return symbole;
    }
    private String symbole;


}