package br.com.vitoriapinto.array;

import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
//        double notasAlunoA[] = new double[3]; Possíbilidade de declaração
        double[] notasAlunoA = new double[4];
        System.out.println(Arrays.toString(notasAlunoA));

        notasAlunoA[0] = 7.9;
        notasAlunoA[1] = 8;
        notasAlunoA[2] = 6.7;
        notasAlunoA[3] = 9.7;

        System.out.println(Arrays.toString(notasAlunoA));
        System.out.println(notasAlunoA[0]); // primeira nota do aluno
        System.out.println(notasAlunoA[notasAlunoA.length -1]); // últ nota do aluno
//        System.out.println(notasAlunoA[4]); ERRO! - posição inexistente

        double totalAlunoA = 0;

        for (int i = 0; i < notasAlunoA.length; i++) {
            totalAlunoA += notasAlunoA[i];
        }

        System.out.println("Média: " + totalAlunoA / notasAlunoA.length);

        final double notaArmazenada = 5.9;
        // Inicialização de valores na criação do array
        double[] notasAlunoB = {6.9, 8.9, notaArmazenada, 10};

        double totalAlunoB = 0;

        for (int i = 0; i < notasAlunoB.length; i++) {
            totalAlunoB += notasAlunoB[i];
        }

        System.out.println("Média: " + totalAlunoB / notasAlunoB.length);
    }
}
