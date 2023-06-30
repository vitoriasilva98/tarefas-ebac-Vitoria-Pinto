package br.com.vitoriapinto.domain;

import java.util.Objects;

public class Usuario {
    String nome;
    String email;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object objeto) {
        if (objeto instanceof Usuario) {
            Usuario outro = (Usuario) objeto;

            boolean nomeIgual = outro.nome.equals(this.nome);
//            boolean emailIgual = outro.email.equals(this.email);
//            return nomeIgual && emailIgual;
            return nomeIgual;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.nome.length();
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Usuario)) return false;
//        Usuario usuario = (Usuario) o;
//        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome, email);
//    }
}
