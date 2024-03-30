package br.com.vitoria.model;

public class Uno extends Carro{

    private String modelo;

    public Uno(String fabricante, Integer anoLancamento, String cor, String modelo) {
        super(fabricante, anoLancamento, cor);
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Uno(" + "modelo: " + modelo + ", " + super.toString() + ")";
    }
}
