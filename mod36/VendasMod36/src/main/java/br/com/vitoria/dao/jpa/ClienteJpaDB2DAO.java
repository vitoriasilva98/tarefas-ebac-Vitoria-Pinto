
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.vitoria.domain.jpa.ClienteJpa;

/**
 * @author vitoria.vitoria
 *
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
