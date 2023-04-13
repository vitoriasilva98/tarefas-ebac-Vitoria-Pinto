package br.com.vitoriapinto;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TarefaParte2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer quantidade;

        System.out.println("************* Tarefa: Coleções - Parte 1  *************");
        do {
            System.out.println("Digite a quantidade de nomes que deseja organizar por gênero: " +
                    "\nPrecisa ser maior ou igual a 2");
            quantidade = scanner.nextInt();
        } while (quantidade < 2);

        separacaoPorGenero(leituraDeNomes(scanner, quantidade));
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
        String conjuntoNomeSexo = "";
        String nome;
        String sexo;

        for (int i = 0; i < quantidade; i++) {
            scanner.nextLine();
            do {
                System.out.println("Digite o " + (i + 1) + "º nome.");
                nome = scanner.nextLine().trim();
            } while (nome.equals(""));

            do {
                System.out.println("Qual é o sexo da "+ (i + 1)+"ª pessoa?" +
                        "\nDigite 'F' para Feminino ou" +
                        "\nDigite 'M' para Masculino");
                sexo = scanner.next().trim().toUpperCase();
            } while(!sexo.equals("F") && !sexo.equals("M"));

            nome = nome.substring(0, 1).toUpperCase().concat(nome.substring(1));
            /*
                A linha de cima transforma a primeira letra do nome em Maiúscula.
                Isso foi necessário pois a ordenação com o TreeSet não funciona com um
                nome que possui a primeira letra minúscula e os outros nomes com a primeira
                letra maiúsculas
             */
            conjuntoNomeSexo += nome + "-" + sexo;
            if (i < (quantidade - 1)) {
                conjuntoNomeSexo += ",";
            }
        }

        System.out.println("Lista de nomes e sexo concatenados: " + conjuntoNomeSexo);

        return conjuntoNomeSexo;
    }

    /**
     * O método realiza a quebra da String com a quantidade de nomes e sexo informada,
     * depois realiza um filtro por gênero e adiciona cada nome em seu respectivo
     * conjunto
     *
     * @param conjuntoNomeSexo
     */
    private static void separacaoPorGenero(String conjuntoNomeSexo) {
        String[] separacaoNomeSexo = conjuntoNomeSexo.split(",");
        Set<String> grupoFeminino = new TreeSet<String>();
        Set<String> grupoMasculino = new TreeSet<String>();
        String[] separacaoSexo;

        for (String conjunto : separacaoNomeSexo) {
            separacaoSexo = conjunto.split("-");

            if (separacaoSexo[1].equals("F")){
                grupoFeminino.add(separacaoSexo[0]);
            }else {
                grupoMasculino.add(separacaoSexo[0]);
            }
        }
        System.out.println("************* Separação de grupos por gênero  *************");
        System.out.println("Grupo Feminino: " + grupoFeminino);
        System.out.println("Grupo Masculino: " + grupoMasculino);
    }

}
