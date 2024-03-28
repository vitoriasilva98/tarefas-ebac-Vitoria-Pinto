package br.com.vitoria.model;

import br.com.vitoria.interfaces.IFabrica;

public class CarroModerno implements IFabrica {
    @Override
    public void criarCarro() {
        System.out.println("Criando carro eletrico");
    }
}
