package br.com.vitoria.model;

import br.com.vitoria.interfaces.IFabrica;

public class CarroTradicional implements IFabrica {
    @Override
    public void criarCarro() {
        System.out.println("Criando carro flex");
    }
}
