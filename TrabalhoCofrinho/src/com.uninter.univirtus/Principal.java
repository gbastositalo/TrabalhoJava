package com.uninter.univirtus;

/**
 *
 * @author gcbit
 * 
 */
import java.util.Scanner;

public class Principal {
    static Scanner teclado = new Scanner(System.in);
    // Singleton Cofrinho estatico, para ser acessivel em toda a classe Principal
    static Cofrinho objCofrinho = Cofrinho.getInstance();
    
    final static double[] valoresReal = {0.05, 0.1, 0.25, 0.5, 1};
    final static double[] valoresPesoArg = {0.05, 0.1, 0.25, 0.5, 1, 2, 5, 10};
    final static double[] valoresDolar = {0.01, 0.05, 0.1, 0.25, 0.5, 1};
    final static double[] valoresEuro = {0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2};
    final static double[] valoresYuan = {0.01, 0.1, 0.5, 1};
    
    /**
     * Ola, leitor(a)
     * Abaixo, voce vera dois metodos estaticos um pouco extensos, peco que nao
     * se assuste. Esses sao os dois metodos que eu desenvolvi para adicionar moedas
     * e remover moedas especificas do Cofrinho. Eu quis elaborar dialogos que
     * mostrassem ao usuario quais sao os valores existentes de cada moeda,
     * para orienta-lo a digitar os valores validos. Nao queria que fosse aceito
     * entrar com um Real de '1' centavo ou com um Dolar de '20' cents.
     * 
     * Essas moedas nao existem. Foi com base nisso que eu fiz as estruturas de
     * validacao de dados, tanto das strings como de doubles.
     * Criei duas estruturas 'switch..case', uma em cada metodo, para selecionar
     * os tipos de Moedas que podem ser adicionadas ou removidas. Em cada 'case',
     * criei inicialmente estruturas condicionais com 'if..elses' para verificar
     * se o decimal que o usuario digitou e compativel com os valores validos de
     * cada moeda.
     * 
     * No entanto, seriam, ao todo, dez cadeias de 'if..elses', ate porque eu me
     * empolguei com a ideia de trabalhar com cinco moedas. Os metodos estavam
     * ficando muito extensos, ate que um colega, que ja havia feito e entregue
     * o trabalho, me sugeriu criar arrays com os valores de cada Moeda e fazer
     * as validacoes a partir de iteracoes e testes com esses arrays.
     * 
     * Essa e a solucao que esta implementada. Os arrays estao declarados como
     * 'final', e estaticos, entao eles podem ser acessados por qualquer metodo
     * dentro da classe Principal.
     * O codigo ficou bem mais abreviado, mas ainda julguei necessario fazer um
     * comentario de documentacao para explicar porque quis contruir as
     * funcionalidades dessa maneira e como funcionam as validacoes de dados.
     */
    
    public static void adicionarMoeda() {    // Metodo de adicionar Moeda
        System.out.print("\nDescreva qual Moeda voce gostaria de adicionar ao Cofrinho:" +
                "\n    (SEM ACENTOS OU CARACTERES ESPECIAIS)" +
                "\n\"REAL\", \"PESOARGENTINO\", \"DOLAR\", \"EURO\" ou \"YUAN\": ");
        // Variavel utilizada para acessar os casos do switch
        String moedaEscolhida = teclado.next();
        // Variavel utilizada nos dialogos da estrutura switch
        double valorMoeda;
        switch(moedaEscolhida.toUpperCase()) {
            case "REAL":
                System.out.println("\nVivo, num pais tropical!");          
                while(true) {
                    try {
                        System.out.print("\nEntre com o valor da Moeda de Real:" +
                                "\n\"0,05\" para 5 centavos, \"0,1\" para 10 centavos" +
                                "\n\"0,25\" para 25 centavos, \"0,5\" para 50 centavos ou" +
                                "\n\"1\" para 1 Real >> ");
                        valorMoeda = teclado.nextDouble();
                    } catch(java.util.InputMismatchException mismatch) {
                        System.out.print("\nSomente numeros decimais sao aceitos!"
                                + "\nTente novamente...");
                        teclado.nextLine();
                        continue;
                    }
                    for(double valor : valoresReal) {
                        if(valorMoeda == valor) {
                            objCofrinho.adicionar(new Real(valorMoeda));
                            System.out.println("\nReal adicionado com sucesso.");
                            break;
                        }
                    }
                    if(valorMoeda!=valoresReal[0] && valorMoeda!=valoresReal[1]
                       && valorMoeda!=valoresReal[2] && valorMoeda!=valoresReal[3]
                            && valorMoeda!=valoresReal[4]) {
                        System.out.println("\nNao ha uma Moeda de Real com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "PESOARGENTINO":
                System.out.println("\nO Sol de Maio se alegra!");
                while(true) {
                    try {
                        System.out.print("\nEntre com o valor da Moeda de Peso Argentino:" +
                                "\n\"0,05\" para 5 centavos, \"0,1\" para 10 centavos," +
                                "\n\"0,25\" para 25 centavos, \"0,5\" para 50 centavos," +
                                "\n\"1\" para 1 Peso, \"2\" para 2 Pesos," +
                                "\n\"5\" para 5 Pesos ou \"10\" para 10 Pesos >> ");
                        valorMoeda = teclado.nextDouble();
                    } catch(java.util.InputMismatchException mismatch) {
                        System.out.print("\nSomente numeros decimais sao aceitos!"
                                + "\nTente novamente...");
                        teclado.nextLine();
                        continue;
                    }
                    for(double valor : valoresPesoArg) {
                        if(valorMoeda == valor) {
                            objCofrinho.adicionar(new Real(valorMoeda));
                            System.out.println("\nPeso adicionado com sucesso.");
                            break;
                        }
                    }
                    if(valorMoeda!=valoresPesoArg[0] && valorMoeda!=valoresPesoArg[1]
                       && valorMoeda!=valoresPesoArg[2] && valorMoeda!=valoresPesoArg[3]
                       && valorMoeda!=valoresPesoArg[4] && valorMoeda!=valoresPesoArg[5]
                       && valorMoeda!=valoresPesoArg[6] && valorMoeda!=valoresPesoArg[7]) {
                        System.out.println("\nNao ha uma Moeda de Peso com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "DOLAR":
                System.out.println("\nMURICA HURR GOD BLESS YOU");
                while(true) {
                    try {
                        System.out.print("\nEntre com o valor da Moeda de Dolar:" +
                               "\n\"0,01\" para 1 cent, \"0,05\" para 5 cents," +
                               "\n\"0,1\" para 10 cents, \"0,25\" para 1 quarter," +
                               "\n\"0,5\" para 1 half Dolar ou \"1\" para 1 Dolar >> ");
                        valorMoeda = teclado.nextDouble();
                    } catch(java.util.InputMismatchException mismatch) {
                        System.out.print("\nSomente numeros decimais sao aceitos!"
                                + "\nTente novamente...");
                        continue;
                    }
                    for(double valor : valoresDolar) {
                        if(valorMoeda == valor) {
                            objCofrinho.adicionar(new Dolar(valorMoeda));
                            System.out.println("\nDolar adicionado com sucesso.");
                            break;
                        }
                    }
                    if(valorMoeda!=valoresDolar[0] && valorMoeda!=valoresDolar[1]
                       && valorMoeda!=valoresDolar[2] && valorMoeda!=valoresDolar[3]
                       && valorMoeda!=valoresDolar[4] && valorMoeda!=valoresDolar[5]) {
                        System.out.println("\nNao ha uma Moeda de Dolar com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "EURO":
                System.out.println("\nEurossaudacoes, meu euroconsiderado.");
                while(true) {
                    try {
                        System.out.print("\nEntre com o valor da Moeda de Euro:"
                        + "\n\"0,01\" para 1 centimo, \"0,02\" para 2 centimos, "
                        + "\n\"0,05\" para 5 centimoa, \"0,1\" para 10 centimos, "
                        + "\n\"0,2\" para 20 centimos, \"0,5\" para 50 centimos, "
                        + "\n\"1\" para 1 Euro ou \"2\" para 2 Euros >> ");
                        valorMoeda = teclado.nextDouble();
                    } catch(java.util.InputMismatchException mismatch) {
                        System.out.print("\nSomente numeros decimais sao aceitos!"
                                + "\nTente novamente...");
                        continue;
                    }
                    for(double valor : valoresEuro) {
                        if(valorMoeda == valor) {
                            objCofrinho.adicionar(new Euro(valorMoeda));
                            System.out.println("\nEuro adicionado com sucesso.");
                            break;
                        }
                    }
                    if(valorMoeda!=valoresEuro[0] && valorMoeda!=valoresEuro[1]
                       && valorMoeda!=valoresEuro[2] && valorMoeda!=valoresEuro[3]
                       && valorMoeda!=valoresEuro[4] && valorMoeda!=valoresEuro[5]
                       && valorMoeda!=valoresEuro[6] && valorMoeda!=valoresEuro[7]) {
                        System.out.println("\nNao ha uma Moeda de Euro com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "YUAN":
                System.out.println("\nXiexie guniang laoshi!");
                while(true) {
                    try {
                        System.out.print("\nEntre com o valor da Moeda de Yuan/Renminbi:"
                                + "\n\"0,01\" para 1 fen, \"0,1\" para 1 jiao,"
                                + "\n\"0,5\" para 5 jian ou \"1\" para 1 Yuan >> ");
                        valorMoeda = teclado.nextDouble();
                    } catch(java.util.InputMismatchException mismatch) {
                        System.out.print("\nSomente numeros decimais sao aceitos!"
                                + "\nTente novamente...");
                        continue;
                    }
                    for(double valor : valoresYuan) {
                        if(valorMoeda == valor) {
                            objCofrinho.adicionar(new Yuan(valorMoeda));
                            System.out.println("\nYuan adicionado com sucesso.");
                            break;
                        }
                    }
                    if(valorMoeda!=valoresYuan[0]&& valorMoeda!=valoresYuan[1]
                       && valorMoeda!=valoresYuan[2]&& valorMoeda!=valoresYuan[3])
                    {
                        System.out.println("\nNao ha uma Moeda de Yuan com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            default:
                System.out.println("\nEntrada invalida. So sao permitidos os textos especificados!");
                adicionarMoeda();
        
        }
    } // adicionarMoeda()
    
    public static void removerMoeda() {    // Metodo de remocao de Moeda
        String moedaEscolhida;
        System.out.print("\nDescreva qual Moeda voce gostaria de remover do Cofrinho:" +
                "\n    (SEM ACENTOS OU CARACTERES ESPECIAIS)" +
                "\n\"REAL\", \"PESOARGENTINO\", \"DOLAR\", \"EURO\" ou \"YUAN\": ");
        // Variavel utilizada para acessar os casos do switch
        moedaEscolhida = teclado.next();
        // Variavel utilizada nos dialogos da estrutura switch
        double valorRemocao;
        switch(moedaEscolhida.toUpperCase()) {
            case "REAL":
                while(true) {
                    System.out.print("\nEntre com o valor da moeda de Real que voce deseja retirar: ");
                    valorRemocao = teclado.nextDouble();
                    for(double valor : valoresReal) {
                        if(valorRemocao == valor) {
                            objCofrinho.remover("Real", valorRemocao);
                            System.out.println("\nReal retirado com sucesso.");
                            break;
                        }
                    }
                    if(valorRemocao!=valoresReal[0]&& valorRemocao!=valoresReal[1]
                      && valorRemocao!=valoresReal[2]&& valorRemocao!=valoresReal[3]
                            && valorRemocao!=valoresReal[4]) {
                        System.out.println("\nNao ha uma Moeda de Real com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "PESOARGENTINO":
                while(true) {
                    System.out.print("\nEntre com o valor da moeda de Peso que voce deseja retirar: ");
                    valorRemocao = teclado.nextDouble();
                    for(double valor : valoresPesoArg) {
                        if(valorRemocao == valor) {
                            objCofrinho.remover("Peso Argentino", valorRemocao);
                            System.out.println("\nPeso retirado com sucesso.");
                            break;
                        }
                    }
                    if(valorRemocao!=valoresPesoArg[0] && valorRemocao!=valoresPesoArg[1]
                       && valorRemocao!=valoresPesoArg[2] && valorRemocao!=valoresPesoArg[3]
                       && valorRemocao!=valoresPesoArg[4] && valorRemocao!=valoresPesoArg[5]
                       && valorRemocao!=valoresPesoArg[6] && valorRemocao!=valoresPesoArg[7])
                    {
                        System.out.println("\nNao ha uma Moeda de Peso com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "DOLAR":
                while(true) {
                    System.out.print("\nEntre com o valor da moeda de Dolar que voce deseja retirar: ");
                    valorRemocao = teclado.nextDouble();
                    for(double valor : valoresDolar) {
                        if(valorRemocao == valor) {
                            objCofrinho.remover("US Dolar", valorRemocao);
                            System.out.println("\nDolar retirado com sucesso.");
                            break;
                        }
                    }
                    if(valorRemocao!=valoresDolar[0]&& valorRemocao!=valoresDolar[1]
                      && valorRemocao!=valoresDolar[2]&& valorRemocao!=valoresDolar[3]
                      && valorRemocao!=valoresDolar[4]&& valorRemocao!=valoresDolar[5]) {
                        System.out.println("\nNao ha uma Moeda de Dolar com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            case "EURO":
                while(true) {
                    System.out.print("\nEntre com o valor da moeda de Euro que voce deseja retirar: ");
                    valorRemocao = teclado.nextDouble();
                    for(double valor : valoresDolar) {
                        if(valorRemocao == valor) {
                            objCofrinho.remover("Euro", valorRemocao);
                            System.out.println("\nEuro retirado com sucesso.");
                            break;
                        }
                    }
                    if(valorRemocao!=valoresEuro[0]&& valorRemocao!=valoresEuro[1]
                      && valorRemocao!=valoresEuro[2]&& valorRemocao!=valoresEuro[3]
                      && valorRemocao!=valoresEuro[4]&& valorRemocao!=valoresEuro[5]
                      && valorRemocao!=valoresEuro[6]&& valorRemocao!=valoresEuro[7]) {
                        System.out.println("\nNao ha uma Moeda de Euro comm esse valor."
                                + "\nTente novamente..");
                        continue;
                    }
                    break;
                }
                break;
            case "YUAN":
                while(true) {
                    System.out.print("\nEntre com o valor da moeda de Yuan que voce deseja retirar: ");
                    valorRemocao = teclado.nextDouble();
                    for(double valor : valoresYuan) {
                        if(valorRemocao == valor) {
                            objCofrinho.remover("Yuan", valorRemocao);
                            System.out.println("\nYuan retirado com sucesso.");
                            break;
                        }
                    }
                    if(valorRemocao!=valoresYuan[0] && valorRemocao!=valoresYuan[1]
                       && valorRemocao!=valoresYuan[2] && valorRemocao!=valoresYuan[3]) {
                        System.out.println("\nNao ha uma Moeda de Yuan com esse valor."
                                + "\nTente novamente...");
                        continue;
                    }
                    break;
                }
                break;
            default:
                System.out.println("\nEntrada invalida. So sao permitidos os textos especificados!");
                removerMoeda();
        }
    } // removerMoeda();
    
    public static void main(String[] args) {
        System.out.print("Bem-Vindo(a) ao seu Gerenciador de Cofrinho!\n" +
                         "    Powered by Italo Bastos\n")
        
        int opcaoMain;
        while(true) {
            try {
                System.out.print("\n\nO que deseja fazer?" +
                        "\n1 - Adicionar uma Moeda ao Cofrinho" +
                        "\n2 - Remover uma Moeda especifica do Cofrinho" +
                        "\n3 - Listar todas as Moedas disponiveis no Cofrinho" +
                        "\n4 - Calcular quanto dinheiro existe no Cofrinho, em Real" +
                        "\n5 - Sair" +
                        "\n>> ");
                opcaoMain = teclado.nextInt();
                    // Excecao lancada sempre que o dado de entrada
                    // for imcompativel com o tipo da variavel declarada
            } catch(java.util.InputMismatchException mismatch) {
                System.out.print("\nSomente numeros inteiros sao aceitos!" +
                        "\nTente novamente...");
                teclado.nextLine(); // Ler o proximo valor de entrada
                continue;
            }
            switch(opcaoMain) {
                case 1:
                    System.out.println("\n  Bem-Vindo(a) ao modulo de Adicionar Moeda!");
                    adicionarMoeda();
                    continue;
                case 2:
                    System.out.println("\n  Bem-Vindo(a) ao modulo de Remover Moeda especifica!");
                    removerMoeda();
                    continue;
                case 3:
                    objCofrinho.listarMoedas();
                    continue;
                case 4:
                    double totalEmReal = objCofrinho.converterTotalEmReal();
                    System.out.printf("\nPerfeito! O valor de todas as Moedas disponiveis,"
                            + "\nconvertidas para o Real, e: %.2f", totalEmReal);
                    continue;
                case 5:
                    break; // Encerrar o switch
                default:
                    System.out.print("\nOs valores devem ser numeros inteiros de 1 ate 5."
                            + "\nTente novamente...");
                    continue;
            }
            break; // Quebra o while, caso 'opcaoMain' seja 5
        }
        // Sera imprimido somente quando o usuario deixar o loop while
        System.out.println("\nCOFRINHO ENCERRADO");
    }
}
