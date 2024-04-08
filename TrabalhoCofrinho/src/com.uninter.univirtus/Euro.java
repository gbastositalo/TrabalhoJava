package com.uninter.univirtus;

public class Euro extends Moeda {
    final String NOME_MOEDA = "Euro";
    double valor;
    final String PAIS = "Uniao Europeia";
    private double multQuotacaoEuro = 5.4; // 1 Euro = 5.4 Reais
    
    public Euro(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void info() {
        System.out.println("\n-------------------------------------------------------");
        System.out.printf("Moeda: %s;  Valor: %.2f;  Pais: %s", NOME_MOEDA, valor, PAIS);
    }
    @Override
    public double converter() {
        double valorConvertido = this.valor * multQuotacaoEuro;
        return valorConvertido;
    }   
}