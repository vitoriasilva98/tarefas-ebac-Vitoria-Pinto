
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.vitoria.domain.jpa.ProdutoJpa;

/**
 * @author vitoria.vitoria
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
