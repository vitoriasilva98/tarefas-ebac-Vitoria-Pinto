package org.example.pacote2;

import org.example.Cliente;
import org.example.pacote1.Classe1;
import org.example.pacote1.Classe2;

/**
 *
 * @author Vitória Pinto
 */

public class Classe3 extends Classe2 {

    /**
     * Comentário do que o método faz
     *
     * @param args valores do sistema
     */
    public static void main(String[] args) {
        Classe1 classe1 = new Classe1();
        Cliente cliente = new Cliente();
        cliente.retornarNomeCliente();
        cliente.getValorTotal();

    }
}
