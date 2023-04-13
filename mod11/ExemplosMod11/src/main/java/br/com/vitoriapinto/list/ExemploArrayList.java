package br.com.vitoriapinto.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  É como um array cujo tamanho podde crescer.
 *  A busca de um elemento é rápida, mas as inserções e exclusões não são.
 *
 * @autor Vitória Pinto
 */
public class ExemploArrayList {

    public static void main(String[] args) {
        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();
        exemploNumeros();
    }

    private static void exemploNumeros() {
        System.out.println("****** exemploNumeros() ******");
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(2);
        Collections.sort(numeros); // Serve para números
        System.out.println(numeros);
    }

    private static void exemploListaSimples() {
        System.out.println("****** exemploListaSimples() ******");
        List<String> lista = new ArrayList<String>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        System.out.println(lista);
        System.out.println("");
    }
    private static void exemploListaSimplesOrdemAscendente() {
        System.out.println("****** exemploListaSimplesOrdemAscendente() ******");
        List<String> lista = new ArrayList<String>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        Collections.sort(lista); // Collections é uma classe utilitária para trabalhar com coleções
        System.out.println(lista);
        System.out.println("");
    }
}
