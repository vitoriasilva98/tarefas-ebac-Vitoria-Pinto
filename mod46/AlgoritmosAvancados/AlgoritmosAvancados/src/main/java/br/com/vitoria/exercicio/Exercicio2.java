package br.com.vitoria.exercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio2 {

    public interface Caixa {
        int[] getValoresDisponiveis();

        int getTroco();
    }

    private static class CaixaRegistradora implements Caixa {
        @Override
        public int[] getValoresDisponiveis() {
            return new int[]{5, 2, 1};
        }

        @Override
        public int getTroco() {
            return 18;
        }
    }

    private class Calculo {

        private int valorGuardado;

        public Calculo() {
            this.valorGuardado = 0;
        }

        public int getValorGuardado() {
            return valorGuardado;
        }

        public void addValorGuardado(int valor) {
            this.valorGuardado += valor;
        }
    }

    public int getQuantidadeDeMoedasDeTroco(CaixaRegistradora cr) {
        int[] valoresDisponiveis = cr.getValoresDisponiveis();
        Arrays.sort(valoresDisponiveis);

        int qtdMoedasDeTroco = 0;
        Calculo calculo = new Calculo();

        List<Integer> list = new ArrayList<>(); // Lista para guardar os valores das moedas

        for (int i = valoresDisponiveis.length - 1; i > -1; i--) {
            boolean valorArmazenado = true;

            while (valorArmazenado) {

                if (calculo.getValorGuardado() == 0) {
                    calculo.addValorGuardado(valoresDisponiveis[i]);
                    qtdMoedasDeTroco++;
                    list.add(valoresDisponiveis[i]);
                }

                if ((calculo.getValorGuardado() + valoresDisponiveis[i]) <= cr.getTroco()) {
                    calculo.addValorGuardado(valoresDisponiveis[i]);
                    list.add(valoresDisponiveis[i]);
                    qtdMoedasDeTroco++;
                } else {
                    valorArmazenado = false;
                }
            }
        }

        System.out.println(list); //Impressão das moedas

        return qtdMoedasDeTroco;
    }

    public static void main(String[] args) {
        Exercicio2 exercicio = new Exercicio2();
        System.out.println("Qtd de moedas de troco: " + exercicio.getQuantidadeDeMoedasDeTroco(new CaixaRegistradora()));
    }

}
