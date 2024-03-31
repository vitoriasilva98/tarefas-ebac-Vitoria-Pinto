package br.com.vitoria;

import br.com.vitoria.annotaions.Tabela;
import br.com.vitoria.model.Periodica;

public class Main {
    public static void main(String[] args) {
        Periodica periodica = new Periodica();
        Tabela tabela = periodica.getClass().getAnnotation(Tabela.class);
        System.out.println("Nome da anotação: " + tabela.nome());
    }
}