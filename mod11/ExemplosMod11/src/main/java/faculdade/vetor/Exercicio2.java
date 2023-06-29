package faculdade.vetor;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[7];

        System.out.println("Por favor, digite uma série de 7 números");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite o %dº número:", (i + 1));
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Ordem em que o elementos do vetor foram salvos");
        for (Integer numero : vetor) {
            System.out.println(numero);
        }

        System.out.println("Ordem inversa em que os elementos do vetor foram salvos");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
}
