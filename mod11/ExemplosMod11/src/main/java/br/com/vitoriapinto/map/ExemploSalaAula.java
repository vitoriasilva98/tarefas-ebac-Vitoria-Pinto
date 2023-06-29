package br.com.vitoriapinto.map;

import br.com.vitoriapinto.domain.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExemploSalaAula {
    public static void main(String[] args) {
        Map<Integer, List<Aluno>> listaSala = new HashMap<>();

        List<Aluno> alunoSala1 = criarTurma("Sala1", 10);
        listaSala.put(1, alunoSala1);

        List<Aluno> alunoSala2 = criarTurma("Sala 2 ", 30);
        listaSala.put(2, alunoSala2);

        imprimirAlunosSala(listaSala.get(1));
    }

    private static List<Aluno> criarTurma(String sala, int count) {
        List<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Aluno aluno = new Aluno("Nome aluno " + i, "Curso" + i, i, sala);
            alunos.add(aluno);
        }

        return alunos;
    }

    private static void imprimirAlunosSala(List<Aluno> alunos) {
        // for java 7 stream
        System.out.println("for java 7 API stream");
        alunos.forEach(aluno -> System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala()));
        System.out.println();

        System.out.println("for java");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala());
        }
        System.out.println();

        System.out.println("for java com contador");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala());
        }
    }
}
