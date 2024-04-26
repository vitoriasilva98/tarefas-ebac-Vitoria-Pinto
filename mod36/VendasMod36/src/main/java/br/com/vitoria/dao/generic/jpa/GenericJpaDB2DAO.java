
package br.com.vitoria.dao.generic.jpa;

import java.io.Serializable;

import br.com.vitoria.domain.jpa.Persistente;

/**
 * @author vitoria.vitoria
 *
 */
public abstract class GenericJpaDB2DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}

}
