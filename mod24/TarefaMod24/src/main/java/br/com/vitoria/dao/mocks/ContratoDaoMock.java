package br.com.vitoria.dao.mocks;

import br.com.vitoria.dao.IContratoDao;


public class ContratoDaoMock implements IContratoDao {

    @Override
    public String salvar() {
        return "Contrato salvo com sucesso!";
    }

    @Override
    public String buscar(Integer contratoId) {

        if(contratoId.equals(1)) {
            return "Contrato milionário";
        }

        return "Id do contrato não encontrado!";
    }

    @Override
    public String excluir(Integer contratoId) {

        if(contratoId.equals(1)) {
            return "Contrato excluido com sucesso!";
        }

        return "Id do contrato não encontrado!";
    }

    @Override
    public String atualizar(Integer contratoId) {

        if(contratoId.equals(1)) {
            return "Contrato atualizado com sucesso!";
        }

        return "Id do contrato não encontrado!";
    }
}
