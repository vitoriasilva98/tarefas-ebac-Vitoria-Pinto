package br.com.vitoria.dao;

import br.com.vitoria.entity.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Produto buscarProduto(String codigoDeBarra) throws Exception;

    public Integer atualizarProduto(Produto produto) throws Exception;

    public Integer excluirProduto(String codigoDeBarra) throws Exception;

    public List<Produto> listarProdutos() throws Exception;
}
