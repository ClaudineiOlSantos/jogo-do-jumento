/*
 *Joguinho do Jumento
 */
package jumento.oh;

import java.util.Scanner;

/**
 *
 * @author claudinei
 */
public class JumentoOh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Duelo duelo;
        Jumento j1, j2;

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        String nome;
        int idade;
        //Inicia player 1
        System.out.println("Informe o nome do jumento 1.");
        nome = input.next();
        System.out.println("Informe a idade do jumento 1.");
        idade = input.nextInt();

        j1 = new Jumento(nome, idade, 1000, 500);

        //Inicia player 2
        System.out.println("Informe o nome do jumento 2.");
        nome = input.next();
        System.out.println("Informe a idade do jumento 2.");
        idade = input.nextInt();

        j2 = new Jumento(nome, idade, 1000, 500);

        //apresenta os jogadores
        System.out.println(j1);
        System.out.println(j2);

        do {

            System.out.println("|------------------------------|");
            System.out.println("|***Escolha a opção desejada***|");
            System.out.println("|------------------------------|");
            System.out.println("|1 - Duelar                    |");
            System.out.println("|0 - sair                      |");
            System.out.println("|------------------------------|");

            System.out.println("O que deseja fazer?");
            opcao = (input.nextInt());

            switch (opcao) {
                case 1:
                    duelo = new Duelo(j1, j2);
                    System.out.println(duelo.iniciaDuelo());

                    System.out.println(j1);
                    System.out.println(j2);
                  
                    break;
                case 0:
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

    }

}
