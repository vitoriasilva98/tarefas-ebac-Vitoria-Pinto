package br.com.vitoriapinto.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExemploIterator {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("João da Silva");
        lista.add("Antônio Sousa");
        lista.add("Lúcia Ferreira");

        Iterator<String> it = lista.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
