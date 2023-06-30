package br.com.vitoriapinto.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.offer("Bia");
        fila.add("Carlos");
        fila.offer("Daniel");
        fila.add("Rafaela");
        fila.offer("Gui");

        System.out.println(fila.peek()); //Ana
        System.out.println(fila.peek()); //Ana
        System.out.println(fila.element()); //Ana
        System.out.println(fila.element()); //Ana

//        fila.size(); // retorna o tamanho da fila
//        fila.clear(); // limpa a fila
//        fila.isEmpty(); // retorna boolean se a fila está vazia ou não
//        fila.contains(...);

        System.out.println(fila.poll()); // Ana
        System.out.println(fila.remove()); // Bia
        System.out.println(fila.poll()); // Carlos
        System.out.println(fila.poll()); // Daniel
        System.out.println(fila.poll()); // Rafaela
        System.out.println(fila.poll()); // Gui
        System.out.println(fila.poll()); // NULL
        System.out.println(fila.poll()); // NULL
        System.out.println(fila.remove()); // exceção
    }
}
