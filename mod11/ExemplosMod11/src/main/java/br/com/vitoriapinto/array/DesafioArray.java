package br.com.vitoriapinto.array;

import java.util.Scanner;

public class DesafioArray {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int tamanhoArray = 0;

        System.out.println("*********** Notas Alunos ***********");
        System.out.println("Quantas notas você deseja digitar?");
        tamanhoArray = leitor.nextInt();

        double[] alunoNotas = new double[tamanhoArray];

        for (int i = 0; i < alunoNotas.length; i++) {
            System.out.println("Digite a " + (1 + i) + "ª nota");
            alunoNotas[i] = leitor.nextDouble();
        }

        double total = 0;

        for (double nota : alunoNotas) {
            total += nota;
        }

        System.out.println("Média: " + (total / alunoNotas.length));
    }
}
