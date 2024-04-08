package com.uninter.univirtus;

class Dolar extends Moeda {
    final String NOME_MOEDA = "US Dolar";
    double valor;
    final String PAIS = "Estados Unidos";
    private double multQuotacaoDolar = 5; // 1 Dolar = 5 Reais
    
    public Dolar(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void info() {
        System.out.println("\n-------------------------------------------------------");
        System.out.printf("Moeda: %s;  Valor: %.2f;  Pais: %s", NOME_MOEDA, valor, PAIS);
    }
    @Override
    public double converter() {
        double valorConvertido = this.valor * multQuotacaoDolar;
        return valorConvertido;
    }
}