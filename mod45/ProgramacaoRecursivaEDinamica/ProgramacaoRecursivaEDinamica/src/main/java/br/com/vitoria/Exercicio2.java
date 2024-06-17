package br.com.vitoria;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio2 {
    private static HashMap<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular o fatorial: ");
        int numero = scanner.nextInt();

        long fatorial = calcularFatorial(numero);

        System.out.println("O fatorial de " + numero + " é " + fatorial);
    }

    // Abordagem Top-Down (Recursiva com Memorização)
    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número deve ser não-negativo.");
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        if (memo.containsKey(numero)) {
            return memo.get(numero);
        }

        long resultado = numero * calcularFatorial(numero - 1);
        memo.put(numero, resultado);

        return resultado;
    }

//    Abordagem Bottom-Up (Iterativa)
//    public static long calcularFatorial(int numero) {
//        if (numero < 0) {
//            throw new IllegalArgumentException("Número deve ser não-negativo.");
//        }
//
//        long[] dp = new long[numero + 1];
//        dp[0] = 1; // Base case: 0! = 1
//
//        for (int i = 1; i <= numero; i++) {
//            dp[i] = i * dp[i - 1];
//        }
//
//        return dp[numero];
//    }
}
