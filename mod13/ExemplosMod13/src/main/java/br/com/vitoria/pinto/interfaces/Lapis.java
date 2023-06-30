package br.com.vitoria.pinto.interfaces;

public class Lapis implements ICaneta {

    private String cor;

    @Override
    public void escrever(String texto) {
        System.out.println("Escrevendo o valor " + texto + " na classe "
                + getClass().getSimpleName());
    }

    @Override
    public String getCor() {
        return "Preto claro";
    }
}
