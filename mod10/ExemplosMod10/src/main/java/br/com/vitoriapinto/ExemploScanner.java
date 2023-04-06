package br.com.vitoriapinto;

import java.util.Scanner;

public class ExemploScanner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a sua idade: ");
        int idade = s.nextInt();
        System.out.println("Você tem " + idade + " anos.");
    }
}