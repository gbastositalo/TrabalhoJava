package com.uninter.univirtus;

class Real extends Moeda {
    final String NOME_MOEDA = "Real";
    double valor;
    final String PAIS = "Brasil";
    // Real nao tem um multiplicador para converter seus valores, pois ja estao em Real
    
    public Real(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void info() {
        System.out.println("\n-------------------------------------------------------");
        System.out.printf("Moeda: %s;  Valor: %.2f;  Pais: %s", NOME_MOEDA, valor, PAIS);
    }
    @Override
    public double converter() {
        return valor;
    }
}
