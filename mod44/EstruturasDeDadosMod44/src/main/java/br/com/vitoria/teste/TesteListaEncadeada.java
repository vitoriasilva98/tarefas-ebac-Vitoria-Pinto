package br.com.vitoria.teste;

import br.com.vitoria.estrutura.ListaEncadeada;
import br.com.vitoria.estrutura.Node;

public class TesteListaEncadeada {
    public static void main(String[] args) {

        ListaEncadeada listaEncadeada = new ListaEncadeada();

        listaEncadeada.push(new Node(2));
        System.out.println("Retornando node: " + listaEncadeada.pop()); // data = 2

        listaEncadeada.push(new Node(2));
        listaEncadeada.push(new Node(4));
        listaEncadeada.push(new Node(6));
        System.out.println("Retornando node: " + listaEncadeada.pop()); // data = 6

        listaEncadeada.push(new Node(10));
        listaEncadeada.printList();

        listaEncadeada.insert(1, new Node(3));

        listaEncadeada.printList(); // 2 3 10

        listaEncadeada.insert(3, new Node(7));

        listaEncadeada.printList(); // 2 3 10 7

        listaEncadeada.remove(4); // Posição inexistente

        listaEncadeada.remove(2);

        listaEncadeada.printList(); // 2 3 7

        listaEncadeada.remove(2);

        listaEncadeada.printList(); // 2 3

        System.out.println("\n" + listaEncadeada.elementAt(0)); // 2
        System.out.println("\n" + listaEncadeada.elementAt(1)); // 3
    }
}
