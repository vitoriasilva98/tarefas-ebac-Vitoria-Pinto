
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.vitoria.domain.jpa.ClienteJpa2;

/**
 * @author vitoria.vitoria
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
