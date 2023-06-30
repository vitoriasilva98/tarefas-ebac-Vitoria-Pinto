package br.com.vitoria.pinto.interfaces;

public class Caminhao implements ICarro{
    @Override
    public void andar() {
        System.out.println("O carro está andando rde vagar");
    }

    @Override
    public void parar() {
        System.out.println("Caminhão parando");
    }


}
