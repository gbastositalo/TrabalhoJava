package com.uninter.univirtus;

class PesoArgentino extends Moeda {
    final String NOME_MOEDA = "Peso Argentino";
    double valor;
    final String PAIS = "Argentina";
    private double multQuotacaoPesoArg = 0.006; // 1 Peso Argentino = 0.006 Real
    
    public PesoArgentino(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void info() {
        System.out.println("\n-------------------------------------------------------");
        System.out.printf("Moeda: %s;  Valor: %.2f;  Pais: %s", NOME_MOEDA, valor, PAIS);
    }
    @Override
    public double converter() {
        double valorConvertido = this.valor * multQuotacaoPesoArg;
        return valorConvertido;
    } 
}
