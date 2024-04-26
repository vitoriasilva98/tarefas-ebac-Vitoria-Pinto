
package br.com.vitoria.services;

import br.com.vitoria.entity.Cliente;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.services.generic.IGenericService;

/**
 * @author vitoria.vitoria
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
