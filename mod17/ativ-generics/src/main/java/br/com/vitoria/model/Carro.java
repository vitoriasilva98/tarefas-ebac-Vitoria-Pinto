package br.com.vitoria.model;

public abstract class Carro {

    private String fabricante;
    private Integer anoLancamento;
    private String cor;

    public Carro(String fabricante, Integer anoLancamento, String cor) {
        this.fabricante = fabricante;
        this.anoLancamento = anoLancamento;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "fabricante: " + fabricante +
                ", anoLancamento: " + anoLancamento +
                ", cor: " + cor;
    }
}
