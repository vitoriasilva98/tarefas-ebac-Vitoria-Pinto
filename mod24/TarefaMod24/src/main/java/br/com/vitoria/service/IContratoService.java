package br.com.vitoria.service;


public interface IContratoService {
    String salvar();

    String buscar(Integer contratoId);

    String excluir(Integer contratoId);

    String editar(Integer contratoId);

}
