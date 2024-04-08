package com.uninter.univirtus;

// Importacao da classe ArrayList para utilizacao na classe Cofrinho
import java.util.ArrayList;
import java.util.Iterator;

public class Cofrinho {
    // Criacao de um ArrayList privado para armazenar instancias de Moeda
    private ArrayList<Moeda> listaMoedas;
    
    /* Variavel do tipo Cofrinho para representar
    o estado de uma instancia, inicialmente como nula */
    private static Cofrinho instancia = null;
    
    // Construtor privado para tornar Cofrinho um Singleton
    private Cofrinho() {
        this.listaMoedas = new ArrayList<Moeda>();
    }
    // Metodo estatico para conseguir uma instancia de Cofrinho
    public static Cofrinho getInstance() {
        if(instancia == null) {
            instancia = new Cofrinho();
        }
        return instancia;
    }
    
    // Metodo que adiciona o objeto passado como parametro no final do Array
    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }
    /* Metodo que itera pelo ArrayList de Cofrinho e busca por uma Moeda
    com base no valor, no subtipo de Moeda e no nome da Moeda*/
    public void remover(String nomeMoeda, double valorRemocao) {
        Iterator<Moeda> itRemocao = this.listaMoedas.iterator();
        while(itRemocao.hasNext()) {
            Moeda moeda = itRemocao.next();
            if(moeda.valor == valorRemocao) {
                if((moeda instanceof Real && moeda.NOME_MOEDA=="Real")||
                   (moeda instanceof PesoArgentino && moeda.NOME_MOEDA=="Peso Argentino")||
                   (moeda instanceof Dolar && moeda.NOME_MOEDA=="US Dolar")||
                   (moeda instanceof Euro && moeda.NOME_MOEDA=="Euro")||
                   (moeda instanceof Yuan && moeda.NOME_MOEDA=="Yuan/Renminbi"))
                {
                    int indiceRemocao = new ArrayList(listaMoedas).indexOf(moeda);
                    this.listaMoedas.remove(indiceRemocao);
                }
            }
        }
    }
    public void listarMoedas() {
        System.out.print("  Muito bem! Segue a lista com todas as Moedas:");
        
        // For-Each objeto da superclasse Moeda em listaMoedas
        for(Moeda moeda : this.listaMoedas) {
            moeda.info();
        }
    }
    public double converterTotalEmReal() {
        double total = 0; // Variavel acumuladora que armazena o total convertido
        
        // For-Each objeto da superclasse Moeda em listaMoedas
        for(Moeda moeda : this.listaMoedas) {
            total += moeda.converter();
        }
        return total;
    }
}