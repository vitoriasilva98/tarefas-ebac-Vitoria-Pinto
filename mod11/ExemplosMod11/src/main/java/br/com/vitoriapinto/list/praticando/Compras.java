package br.com.vitoriapinto.list.praticando;

import br.com.vitoriapinto.domain.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compras {
    public static void main(String[] args) {
        listaDeSuperMercado();
    }

    private static void listaDeSuperMercado() {
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto(501L, "Leite integral - 1L", "Italac", 5.99));
        produtos.add(new Produto(21L, "Papel Higienico - 12 rolos", "Neves", 23.90));
        produtos.add(new Produto(122L, "Ovos - 20 unidades", "OvoBom", 12.00));
        produtos.add(new Produto(111L, "Pão de forma", "Pullman", 9.99));
        System.out.println(produtos);
//        Collections.sort(produtos,);
    }
}
