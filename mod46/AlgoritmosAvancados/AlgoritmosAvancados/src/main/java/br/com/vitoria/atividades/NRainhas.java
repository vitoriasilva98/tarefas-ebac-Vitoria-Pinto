package br.com.vitoria.atividades;

public class NRainhas {

    private static boolean temAtaque(int x, int y, int[][] tab) {
        return false;
    }

    private static boolean resolveNRainhas(int[][] tab, int n) {
        // Checa se todas as rainhas foream colocadas
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (temAtaque(i, j, tab)) {
                    continue;
                }

                // Colocando a rainha no tabuleiro
                tab[i][j] = 1;

                if (resolveNRainhas(tab, n - 1)) {
                    return true;
                }

                // solução não foi enctrada, desfazendo a última mudança
                tab[i][j] = 0;
            }
        }

        return false;
    }
}
