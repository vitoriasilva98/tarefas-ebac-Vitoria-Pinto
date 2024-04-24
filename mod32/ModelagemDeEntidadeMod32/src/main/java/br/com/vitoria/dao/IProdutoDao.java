package br.com.vitoria.dao;

import br.com.vitoria.entity.Produto;

import java.util.List;

public interface IProdutoDao {

    Produto cadastrar(Produto produto);

    Produto consultar(Long proId);

    List<Produto> listarProdutos();

    void excluir(Produto produto);
}
