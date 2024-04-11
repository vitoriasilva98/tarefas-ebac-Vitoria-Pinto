package br.com.vitoria.dao;


public class ContratoDao implements IContratoDao {

    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public String buscar(Integer contratoId) {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public String excluir(Integer contratoId) {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public String atualizar(Integer contratoId) {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }
}
