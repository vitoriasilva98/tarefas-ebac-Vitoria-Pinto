
package br.com.vitoria.dao;

import java.util.List;

import br.com.vitoria.dao.generic.IGenericDAO;
import br.com.vitoria.domain.Cliente;

/**
 * @author vitoria.vitoria
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}
