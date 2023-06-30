package br.com.vitoriapinto.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

    public static void main(String[] args) {

        Deque<String> livros = new ArrayDeque<>();

        livros.add("O Pequeno Príncipe");
        livros.push("Dom Quixote");
        livros.push("O Hobbit");

        System.out.println(livros.peek()); // O Hobbit
        System.out.println(livros.element()); // O Hobbit

        for(String livro: livros) {
            System.out.println(livro);
        }

        System.out.println(livros.pop()); // O Hobbit
        System.out.println(livros.poll()); // Dom Quixote
        System.out.println(livros.poll()); // O Pequeno Príncipe
        System.out.println(livros.poll()); // Null
        System.out.println(livros.poll()); // Null
//        System.out.println(livros.pop()); // Exceção
//        System.out.println(livros.remove()); // Exceção

//        livros.size();
//        livros.clear();
//        livros.contains(...);
//        livros.isEmpty();

        System.out.println(livros);
    }
}
