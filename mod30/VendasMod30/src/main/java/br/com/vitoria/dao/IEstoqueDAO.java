package br.com.vitoria.dao;

import br.com.vitoria.dao.generic.IGenericDAO;
import br.com.vitoria.domain.Estoque;

public interface IEstoqueDAO extends IGenericDAO<Estoque, String> {

    public Integer verificarQuantidadeDoProdutoNoEstoque(Long produtoId) throws Exception;

    public void atualizarEstoque(Long produtoId, Integer qtdAtualizada) throws Exception;
}
