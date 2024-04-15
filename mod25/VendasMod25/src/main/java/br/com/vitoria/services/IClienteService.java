/**
 * 
 */
package br.com.vitoria.services;

import br.com.vitoria.domain.Cliente;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;


public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
