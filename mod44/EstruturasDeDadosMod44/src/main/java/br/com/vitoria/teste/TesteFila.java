package br.com.vitoria.teste;

import br.com.vitoria.estrutura.Fila;

public class TesteFila {
    public static void main(String[] args) {

        Fila fila = new Fila(4);

        System.out.println("A fila está vazia: " + fila.isEmpty()); // true

        fila.enqueue(2);

        System.out.println("Tamanho da fila: " + fila.size()); // 1

        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(1);

        System.out.println(fila);

        System.out.println("\nPrimeiro da fila: " + fila.front());
        System.out.println("Último da fila: " + fila.rear());

        fila.dequeue();

        System.out.println(fila);

        System.out.println("\nPrimeiro da fila: " + fila.front());
        System.out.println("Último da fila: " + fila.rear());
    }
}
