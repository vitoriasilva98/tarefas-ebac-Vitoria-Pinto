package br.com.vitoria.teste;

import br.com.vitoria.estrutura.Pilha;

public class TestePilha {
    public static void main(String[] args) {

        Pilha pilha = new Pilha(3);

        System.out.println("A pilha está vázia: " + pilha.isEmpty());

        pilha.push(1);
        System.out.println("\nTamanho pilha: " + pilha.size()); // 1
        pilha.printPilha();

        pilha.push(2);
        System.out.println("\nTamanho pilha: " + pilha.size()); // 2
        pilha.printPilha();

        pilha.push(3);
        System.out.println("\nTamanho pilha: " + pilha.size()); // 3
        pilha.printPilha();

        pilha.push(4); // Mensagem: pilha cheia
        System.out.println("\nTamanho pilha: " + pilha.size()); // 3

        System.out.println("Número do topo da pilha: " + pilha.top()); // 3

        pilha.pop(); // Irá remover o número 3

        System.out.println("\nTamanho pilha: " + pilha.size()); // Precisa ser 2
        System.out.println("Número do topo da pilha: " + pilha.top()); // Precisa ser o número 2

        System.out.println("A pilha está vázia: " + pilha.isEmpty());
    }

}