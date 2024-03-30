package br.com.vitoria.model;

public class Gol extends Carro{

    private String modelo;

    public Gol(String fabricante, Integer anoLancamento, String cor, String modelo) {
        super(fabricante, anoLancamento, cor);
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Gol(" + "modelo: " + modelo + ", " + super.toString() + ")";
    }
}
