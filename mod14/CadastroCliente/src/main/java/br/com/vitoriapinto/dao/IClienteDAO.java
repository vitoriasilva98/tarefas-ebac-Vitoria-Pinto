package br.com.vitoriapinto.dao;

import br.com.vitoriapinto.entity.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadatrar(Cliente cliente);

    public void exluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
