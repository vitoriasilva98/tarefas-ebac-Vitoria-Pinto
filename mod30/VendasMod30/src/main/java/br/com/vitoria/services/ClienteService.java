
package br.com.vitoria.services;

import br.com.vitoria.dao.IClienteDAO;
import br.com.vitoria.domain.Cliente;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.MaisDeUmRegistroException;
import br.com.vitoria.exceptions.TableException;
import br.com.vitoria.services.generic.GenericService;

/**
 * @author vitoria.vitoria
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}


	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
