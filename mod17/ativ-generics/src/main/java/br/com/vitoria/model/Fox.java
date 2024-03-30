package br.com.vitoria.model;

public class Fox extends Carro {

    private String modelo;

    public Fox(String fabricante, Integer anoLancamento, String cor, String modelo) {
        super(fabricante, anoLancamento, cor);
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Fox(" + "modelo: " + modelo + ", " + super.toString() + ")";
    }
}
