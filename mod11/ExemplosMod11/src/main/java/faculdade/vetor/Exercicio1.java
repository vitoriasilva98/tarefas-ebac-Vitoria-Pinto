package faculdade.vetor;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[6];
        int qtdNumPares = 0;
        int total = 0;

        System.out.println("Por favor, digite uma série de 6 números: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite %dº número: ", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Números digitados: ");
        for (Integer numero : vetor) {
            System.out.println(numero);
            if ((numero % 2) == 0) {
                qtdNumPares++;
            }
            total += numero;
        }
        System.out.println("Total: " + total);
        System.out.println("Quantidade de números pares: " + qtdNumPares);
    }
}
