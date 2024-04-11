package br.com.vitoria.service;

import br.com.vitoria.dao.IContratoDao;


public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        return contratoDao.salvar();
    }

    @Override
    public String buscar(Integer contratoId) {
        if (contratoId != null) {
            return contratoDao.buscar(contratoId);
        }

        return "Id do contrato não pode ser nulo";
    }

    @Override
    public String excluir(Integer contratoId) {
        if (contratoId != null) {
            return contratoDao.excluir(contratoId);
        }

        return "Id do contrato não pode ser nulo";
    }

    @Override
    public String editar(Integer contratoId) {
        if (contratoId != null) {
            return contratoDao.atualizar(contratoId);
        }

        return "Id do contrato não pode ser nulo";
    }
}
