package br.com.vitoria.service;

import br.com.vitoria.dao.ClienteDao;
import br.com.vitoria.dao.ClienteDaoMock;
import br.com.vitoria.dao.IClienteDao;


public class ClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        //clienteDao = new ClienteDao();
        //clienteDao = new ClienteDaoMock();
        this.clienteDao = clienteDao;
    }

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }
}
