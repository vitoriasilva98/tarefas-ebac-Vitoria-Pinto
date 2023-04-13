package br.com.vitoriapinto.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ExemploLinkedList {

    public static void main(String[] args) {
        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();
    }

    private static void exemploListaSimples() {
        System.out.println("****** exemploListaSimples() ******");
        List<String> lista = new LinkedList<>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        System.out.println(lista);
        System.out.println("");

        lista.remove(0); // remoção de um indice - João
        boolean contem = lista.contains("João da Silva"); // False
        System.out.println(lista);
        System.out.println(contem);

        System.out.println(lista.get(0));

        for (String nome : lista) {
            System.out.println(nome);
        }
    }
    private static void exemploListaSimplesOrdemAscendente() {
        System.out.println("****** exemploListaSimplesOrdemAscendente() ******");
        List<String> lista = new LinkedList<String>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        Collections.sort(lista); // Collections é uma classe utilitária para trabalhar com coleções
        System.out.println(lista);
        System.out.println("");
    }
}
