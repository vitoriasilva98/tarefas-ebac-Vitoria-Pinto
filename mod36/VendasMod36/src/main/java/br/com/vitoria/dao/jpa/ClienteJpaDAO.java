
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.vitoria.domain.jpa.ClienteJpa;

/**
 * @author vitoria.vitoria
 *
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements br.com.vitoria.dao.jpa.IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
