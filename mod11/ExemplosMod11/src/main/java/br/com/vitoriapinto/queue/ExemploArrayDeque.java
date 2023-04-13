package br.com.vitoriapinto.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExemploArrayDeque {
    public static void main(String[] args) {
        inserindoNaFila();
        removendoDaFila();
        acessandoDaFila();
    }

    private static void acessandoDaFila() {
        System.out.println("***** ACESSANDO *****");
        Deque<String> ad = new ArrayDeque<String>();
        ad.add("Red");
        ad.add("Blue");
        ad.add("White");
        ad.add("Yellow");
        ad.add("Black");

        Deque<String> d = new ArrayDeque<String>();
        d.add("Green");
        d.add("Orange");
        ad.addAll(d); // Adiciona uma fila dentro de uma outra fila

        System.out.println(ad);
        System.out.println(ad.contains("White")); // True
        System.out.println(ad.contains("Brown")); // False
        System.out.println(ad.containsAll(d)); // Verifica se contém os itens da fila "d" - True

        System.out.println("Output of elements: " + ad.element());
        System.out.println("Get first element using getFirst: " + ad.getFirst());
        System.out.println("Get last element using getLast: " + ad.getLast());
        System.out.println("Output of peek: " + ad.peek());
        System.out.println("Get first element using peekFirst: " + ad.peekFirst());
        System.out.println("Get last element using peekLast: " + ad.peekLast());
        System.out.println();
    }

    private static void removendoDaFila() {
        System.out.println("***** REMOVENDO *****");
        Deque<String> ad = new ArrayDeque<String>();
        ad.add("Red");
        ad.add("Blue");
        ad.add("white");
        ad.add("Yellow");
        ad.add("Black");

        Deque<String> d = new ArrayDeque<String>();
        d.add("Pink");
        d.add("Green");
        d.add("Purple");
        d.add("Orange");
        d.add("Brown");

        ad.addAll(d);
        System.out.println("elements in the ArrayDeque: " + ad);

        String val = ad.remove();
        ad.remove("Black");
        ad.removeLast();

        System.out.println("Elements in the ArrayDeque after removeFirst and removeLast: " + ad);

        ad.poll();
        ad.pollFirst();
        ad.pollLast();

        System.out.println("Elements in the ArrayDeque after poll, pollFirst, pollLast: " + ad);

        ad.pop();
        System.out.println("Elements in the ArrayDeque after pop: " + ad);

        ad.retainAll(d);
        System.out.println("Elements in the ArrayDeque after retainAll: " + ad);

        ad.removeAll(d);
        System.out.println("Elements in the ArrayDeque after removeAll: " + ad);
        System.out.println("");
    }

    private static void inserindoNaFila() {
        System.out.println("***** INSERINDO *****");

        Deque<String> d = new ArrayDeque<String>();
        d.add("Delhi");
        d.addFirst("Bangalore");
        d.addLast("Chennai");

        System.out.println("Elements in the Deque after add, addFirst and addLast: " + d);

        Deque<String> dq = new ArrayDeque<String>();
        dq.add("Hyderabad");
        dq.add("Trivandrum");

        d.addAll(dq);

        System.out.println("Elements in the Deque after addAll: " + d);

        boolean val = d.offer("Jaipur");
        d.offerFirst("Goa");
        d.offerLast("Mumbai");

        System.out.println("Elements in the Deque after push: " + d);

        d.push("Kolkata");

        System.out.println("Elements in the Deque after push: + d");
        System.out.println("");
    }
}
