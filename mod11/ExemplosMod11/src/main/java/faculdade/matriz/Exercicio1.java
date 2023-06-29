package faculdade.matriz;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[][] matriz = new int[2][3];

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.printf("Digite o número da %dª coluna da %dª linha: ", coluna + 1, linha + 1);
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        leitorMatriz(matriz);
    }

    private static void leitorMatriz(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] +"\t");
            }
            System.out.println();
        }
    }
}
