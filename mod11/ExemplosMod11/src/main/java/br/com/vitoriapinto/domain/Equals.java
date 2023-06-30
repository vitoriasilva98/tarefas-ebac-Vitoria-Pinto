package br.com.vitoriapinto.domain;

import java.util.Date;

public class Equals {
    public static void main(String[] args) {

        Usuario u1 = new Usuario();
        u1.nome = "Pedro Silva";
        u1.email = "pedro.silva@ezemail.com.br";

        Usuario u2 = new Usuario();
        u2.nome = "Pedro Silva";
        u2.email = "pedro.silva@ezemail.com.br";

        System.out.println(u1 == u2); // FALSE
        System.out.println(u1.equals(u2)); // TRUE
        System.out.println(u2.nome.equals(u1.nome)); // TRUE

        System.out.println(u2.equals(new Date())); // Exceção
    }
}
