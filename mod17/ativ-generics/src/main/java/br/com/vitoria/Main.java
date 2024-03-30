package br.com.vitoria;

import br.com.vitoria.model.Carro;
import br.com.vitoria.model.Fox;
import br.com.vitoria.model.Gol;
import br.com.vitoria.model.Uno;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<Carro>();

        Fox fox = new Fox("Volkswagen", 2018, "Azul", "Fox");
        Gol gol = new Gol("Volkswagen", 2014, "Prata", "Gol");
        Uno uno = new Uno("Fiat", 2020, "Preto", "Uno");

        carros.add(fox);
        carros.add(gol);
        carros.add(uno);

        imprimirListaDeCarros(carros);
    }

    private static void imprimirListaDeCarros(List<Carro> carros) {
        System.out.println("********** Lista de carros **********");
        for (Carro carro : carros) {
            System.out.println(carro +"\n");
        }
    }
}