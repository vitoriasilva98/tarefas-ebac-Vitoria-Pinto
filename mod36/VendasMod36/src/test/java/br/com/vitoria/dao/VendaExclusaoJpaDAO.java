
package br.com.vitoria.dao;

import br.com.vitoria.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.vitoria.dao.jpa.IVendaJpaDAO;
import br.com.vitoria.domain.jpa.VendaJpa;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author vitoria.vitoria
 *
 * Classe utilizada somente no teste para fazer a exclusão das vendas
 *
 */
public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
