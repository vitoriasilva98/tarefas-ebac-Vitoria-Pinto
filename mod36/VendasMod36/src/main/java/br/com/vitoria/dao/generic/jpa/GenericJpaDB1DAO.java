
package br.com.vitoria.dao.generic.jpa;

import java.io.Serializable;

import br.com.vitoria.domain.jpa.Persistente;

/**
 * @author vitoria.vitoria
 *
 */
public abstract class GenericJpaDB1DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB1DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre1");
	}

}
