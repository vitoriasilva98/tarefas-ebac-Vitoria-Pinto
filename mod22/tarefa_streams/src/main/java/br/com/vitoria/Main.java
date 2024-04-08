package br.com.vitoria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String listaDeNomesEGeneros = "Ana-F, Pedro-M, Maria-F, Larissa-F, Mariana-F, João-M, Luís-M, Bruno-M, Jesus-M, Beatriz-F";

        // Esse array realiza a separação dos valores string utilizando o método split
        String[] nomesEhGeneroSeparadosPorVirgula = listaDeNomesEGeneros.split(",");

        // Esse Stream realiza o filtro pela marcação de gênero
        List<String> listaFemininaComGenero = Arrays.stream(nomesEhGeneroSeparadosPorVirgula).filter(nomesEGeneros -> nomesEGeneros.contains("-F")).collect(Collectors.toList());

        // Esse Stream remove a marcação de gênero
        List<String> listaFemininaSemGenero = listaFemininaComGenero.stream().map(nome -> nome.replace("-F", "")).collect(Collectors.toList());

        System.out.println("Lista completa: " + listaDeNomesEGeneros);
        System.out.println("\nLista de nomes Eh Genero Separados Por Virgula: " + listaFemininaSemGenero);
        System.out.println("\nLista Feminina Com Genero: " + listaFemininaComGenero);
        System.out.println("\nLista Feminina Sem Genero: " + listaFemininaSemGenero);
    }

}