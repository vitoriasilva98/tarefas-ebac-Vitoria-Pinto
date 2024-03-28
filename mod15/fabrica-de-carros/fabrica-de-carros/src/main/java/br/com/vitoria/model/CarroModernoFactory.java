package br.com.vitoria.model;

import br.com.vitoria.interfaces.IFabrica;

public class CarroModernoFactory extends EmpresaFactory {
    @Override
    public IFabrica criandoFabrica() {
        return new CarroModerno();
    }
}
