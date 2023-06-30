package br.com.vitoria.pinto.agregacao;

public class Programa {

    public static void main(String[] args) {

        Produto produtoTV = criarProduto(1L, 10d, "TV");
        Produto produtoCel = criarProduto(12L, 1000d, "Celular");

        Vendedor vendedor = criarVendedor("Rodrigo", 10d);

        Comprador comprador = criarComprador("Maria", 2000d);

        Venda venda = new Venda();
        venda.setVendedor(vendedor);
        venda.setComprador(comprador);
        venda.add(produtoTV);
        venda.add(produtoCel);

        venda.concretizarVenda();
        System.out.println(venda);
        venda.cancelarVenda();
        venda = null;
        System.out.println("Fim");
    }

    private static Comprador criarComprador(String nome, Double verba) {
        return new Comprador(nome, verba);
    }

    private static Vendedor criarVendedor(String nome, Double comissao) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        vendedor.setComissao(comissao);
        return vendedor;
    }

    private static Produto criarProduto(Long  codigo, Double valor, String nome) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setPreco(valor);
        produto.setNome(nome);
        return produto;
    }
}
