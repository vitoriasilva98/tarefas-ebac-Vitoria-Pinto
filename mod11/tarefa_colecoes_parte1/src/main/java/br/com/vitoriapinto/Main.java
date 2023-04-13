package br.com.vitoriapinto;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer quantidade;

        System.out.println("************* Tarefa: Coleções - Parte 1  *************");
        do {
            System.out.println("Digite a quantidade de nomes que deseja ordenar: " +
                    "\nPrecisa ser maior ou igual a 2");
            quantidade = scanner.nextInt();
        } while (quantidade < 2);

        Set<String> lista = separacaoOrdenacaoNomes(leituraDeNomes(scanner, quantidade));
        System.out.println("Lista de nomes ordenados com TreeSet: " + lista);
    }

    /**
     * Esse método faz a leitura da quantidade de nomes informada através do console.
     *
     * @param scanner,quantidade
     * @return listaNomes - contendo uma String com os nomes separados por vírgula.
     */
    private static String leituraDeNomes(Scanner scanner, Integer quantidade) {
        System.out.println("******************* Leitura de nomes *******************");
        System.out.println("Por favor, digite os " + quantidade + " nomes: ");
        String listaNomes = "";
        String nome;

        scanner.nextLine();
        for (int i = 0; i < quantidade; i++) {
            do {
                System.out.println("Digite o " + (i + 1) + "º nome.");
                nome = scanner.nextLine().trim();
            } while (nome.equals(""));

            nome = nome.substring(0, 1).toUpperCase().concat(nome.substring(1));
            /*
                A linha de cima transforma a primeira letra do nome em Maiúscula.
                Isso foi necessário pois a ordenação com o TreeSet não funciona com um
                nome que possui a primeira letra minúscula e os outros nomes com a primeira
                letra maiúsculas
             */
            listaNomes += nome;
            if (i < (quantidade - 1)) {
                listaNomes += ",";
            }
        }

        System.out.println("Lista de nomes com vígula: " + listaNomes);

        return listaNomes;
    }

    /**
     * O método realiza a quebra da String com a quantidade de nomes informada e
     * adiciona dentro de um conjunto que ordena de forma automática pelo TreeSet
     *
     * @param nomes
     * @return lista - retornando conjunto da interface tipo do Set com os nomes
     */
    private static Set<String> separacaoOrdenacaoNomes(String nomes) {
        String[] nomesSeparados = nomes.split(",");
        Set<String> lista = new TreeSet<>();

        for (String nome : nomesSeparados) {
            lista.add(nome);
        }

        return lista;
    }
}