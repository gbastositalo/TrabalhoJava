package com.uninter.univirtus;

class Yuan extends Moeda {
    final String NOME_MOEDA = "Yuan/Renminbi";
    double valor;
    final String PAIS = "China";
    private double multQuotacaoYuan = 0.7; // 1 Yuan = 0.7 Real
    
    public Yuan(double valor) {
        this.valor = valor;
    }
    
    @Override
    public void info() {
        System.out.println("\n-------------------------------------------------------");
        System.out.printf("Moeda: %s;  Valor: %.2f;  Pais: %s", NOME_MOEDA, valor, PAIS);
    }
    @Override
    public double converter() {
        double valorConvertido = this.valor * multQuotacaoYuan;
        return valorConvertido;
    }
}