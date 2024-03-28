package br.com.vitoria;

import br.com.vitoria.interfaces.IFabrica;
import br.com.vitoria.model.CarroModernoFactory;
import br.com.vitoria.model.CarroTradicionalFactory;
import br.com.vitoria.model.EmpresaFactory;

public class Main {
    public static void main(String[] args) {
        EmpresaFactory empresaModerna = new CarroModernoFactory();
        IFabrica fabricaModerna = empresaModerna.criandoFabrica();
        fabricaModerna.criarCarro();

        EmpresaFactory empresaTradicional = new CarroTradicionalFactory();
        IFabrica fabricaTradiconal = empresaTradicional.criandoFabrica();
        fabricaTradiconal.criarCarro();
    }
}