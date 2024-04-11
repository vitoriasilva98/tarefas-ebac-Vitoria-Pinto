package br.com.vitoria.dao;


public interface IContratoDao {
    String salvar();

    String buscar(Integer contratoId);

    String excluir(Integer contratoId);

    String atualizar(Integer contratoId);

}
