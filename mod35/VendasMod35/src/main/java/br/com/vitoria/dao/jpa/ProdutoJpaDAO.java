
package br.com.vitoria.dao.jpa;

import br.com.vitoria.dao.generic.jpa.GenericJpaDAO;
import br.com.vitoria.entity.jpa.ProdutoJpa;

/**
 * @author vitoria.vitoria
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
