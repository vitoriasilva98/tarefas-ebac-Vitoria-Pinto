package br.com.vitoria;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular o fatorial: ");
        int numero = scanner.nextInt();

        long fatorial = calcularFatorial(numero);

        System.out.println("O fatorial de " + numero + " é " + fatorial);
    }

    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo.");
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        return numero * calcularFatorial(numero - 1);
    }
}