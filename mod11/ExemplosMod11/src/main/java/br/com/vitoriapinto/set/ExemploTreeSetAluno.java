package br.com.vitoriapinto.set;

import br.com.vitoriapinto.domain.Aluno;

import java.util.Set;
import java.util.TreeSet;

public class ExemploTreeSetAluno {
    public static void main(String[] args) {
        exemploListaSimples();
    }

    /**
     * Para não repetir objetos na lista de alunos é necessário que a classe
     * Aluno implemente a classe Comprable
     * Tem ordem natural dos obejtos
     */
    private static void exemploListaSimples() {
        Set<Aluno> conjunto = new TreeSet<Aluno>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Antonio Sousa", "OpenOffice", 10);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);
    }
}
