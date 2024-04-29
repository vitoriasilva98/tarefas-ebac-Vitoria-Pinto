
package br.com.vitoria.service;

import java.util.List;

import br.com.vitoria.domain.Cliente;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.services.generic.IGenericService;

/**
 * @author vitoria.vitoria
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
