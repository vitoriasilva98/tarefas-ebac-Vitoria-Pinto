
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.IGenericJapDAO;
import br.com.vitoria.domain.jpa.Persistente;

/**
 * @author vitoria.vitoria
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
