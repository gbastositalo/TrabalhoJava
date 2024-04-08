package com.uninter.univirtus;

// Classe abstrata representa uma moeda generica
abstract class Moeda {
    String NOME_MOEDA;
    double valor;
    
    public abstract void info();
    public abstract double converter();
}