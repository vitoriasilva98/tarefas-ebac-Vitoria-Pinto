
package br.com.vitoria.services;

import br.com.vitoria.domain.Cliente;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.services.generic.IGenericService;

/**
 * @author vitoria.vitoria
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
