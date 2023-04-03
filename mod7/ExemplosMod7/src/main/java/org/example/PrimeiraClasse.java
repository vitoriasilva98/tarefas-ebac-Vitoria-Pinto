package org.example;

public class PrimeiraClasse {
    public static void main(String[] args) {
        System.out.println("Olá Vitória!");
        Cliente cliente = new Cliente();
        cliente.setCodigo(1);
        cliente.cadastrarEndereco("Rua 1");
        cliente.setNome("Vitória");
        System.out.println(cliente.getCodigo() );
        cliente.imprimirEndereco();
        String end = cliente.retornarNomeCliente();
        System.out.println(end);
    }
}
