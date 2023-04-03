package org.example;
public class Operadores {

    public static void main(String[] args) {
        operacoesAritmetica();
        operacoesAtribuicoes();
        operacoesIncrementoDecremento();
        operacoesRelacionais();
        operacoesLogicas();
    }

    private static void operacoesLogicas() {
        System.out.println("**** operacoesLogicas ****");
        int num1 = 10;
        // Operadores lógicos

        boolean isDentro10 = num1 >= 1  && num1 <=10;
        System.out.println("isDentro10: " + isDentro10); // true

        boolean isDentro_10 = num1 >= 1  || num1 <=10;
        System.out.println("isDentro_10: " + isDentro_10); // true

        boolean isNot = num1 >= 1;
        System.out.println("isNot: " + !isNot); // false
        // ! (not) - nega o valor da variável se for 'true' ele inverte para 'false' e vice e versa
    }

    private static void operacoesRelacionais() {
        System.out.println("**** operacoesRelacionais ****");
        int num1 = 10;
        int num2 = 10;
        boolean isMaior = num1 > num2;
        System.out.println("isMaior: " + isMaior); // false

        boolean isIgual = num1 == num2;
        System.out.println("isIgual: " + isIgual); // true

        boolean isDiferente = num1 != num2;
        System.out.println("isDiferente: " + isDiferente); // false

        boolean isMaiorIgual = num1 >= num2;
        System.out.println("isMaiorIgual: " + isMaiorIgual); // true
    }

    private static void operacoesIncrementoDecremento() {
        System.out.println("**** operacoesIncrementoDecremento ****");

        int num1 = 10;
        System.out.println(num1); // 10
        num1++;  // mesma coisa do que num1 + 1;
        System.out.println(num1); // 11

        num1--;  // mesma coisa do que num1 - 1;
        System.out.println(num1); // 10
    }

    private static void operacoesAtribuicoes() {
        System.out.println("**** operacoesAtribuicoes ****");
        int numero1 = 10;
        int numero2 = 10;
        int numero3 = numero1 + numero2;
        System.out.println(numero3);
        numero3 += numero3;
        int numero4 = numero3 + 20; // Essa linha faz a mesma coisa que alinha de cima
        System.out.println(numero3);
    }

    public static void operacoesAritmetica() {
        System.out.println("**** operacoesAritmeticas ****");
        int num1 = 10;
        int num2 = 20;

        int num3 = num1 + num2;
        int num4 = num1 - num2;
        int num5 = num1 / num2;
        int num6 = num1 * num2;
        int num7 = (10 + 10)/2;

        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(num7);
    }

}
