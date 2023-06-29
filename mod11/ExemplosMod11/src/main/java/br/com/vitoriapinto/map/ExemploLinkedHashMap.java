package br.com.vitoriapinto.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A ordem de iteração é a ordem em que as chaves são inseridas no mapa.
 */
public class ExemploLinkedHashMap {

    public static void main(String[] args) {
        exemploListaSimples();
    }

    private static void exemploListaSimples() {
        System.out.println("***********  exemploListaSimples ***********");
        Map<Integer, String> lista = new LinkedHashMap<>();
        lista.put(1, "João da Silva");
        lista.put(2, "Antônio Sousa");
        lista.put(4, "João da Silva");
        lista.put(3, "Lúcia Ferriera");

        System.out.println(lista);
        System.out.println();
    }
}
