package br.com.vitoria.pinto.interfaces;

public class CarroPasseio implements  ICarro{
    @Override
    public void andar() {
        System.out.println("O carro está andando rápido");
    }
}
