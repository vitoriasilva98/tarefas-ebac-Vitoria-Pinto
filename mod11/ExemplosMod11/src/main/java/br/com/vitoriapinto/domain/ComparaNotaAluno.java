package br.com.vitoriapinto.domain;

import java.util.Comparator;

public class ComparaNotaAluno implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        // return Double.valueOf(o1.getNota()).compateTo(Double.valueOf(o2.getNota());
        // return Double.compare(o2.getNota(), o1.getNota());
        return Double.compare(o2.getNota(), o1.getNota());
    }
}
