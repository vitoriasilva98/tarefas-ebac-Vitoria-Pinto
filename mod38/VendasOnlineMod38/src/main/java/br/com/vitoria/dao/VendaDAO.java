
package br.com.vitoria.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.vitoria.dao.generic.GenericDAO;
import br.com.vitoria.domain.Cliente;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.domain.Venda;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author vitoria.vitoria
 *
 */
public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

	public VendaDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void excluir(Venda entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			entity.getProdutos().forEach(prod -> {
				Produto prodJpa = entityManager.merge(prod.getProduto());
				prod.setProduto(prodJpa);
			});
			Cliente cliente = entityManager.merge(entity.getCliente());
			entity.setCliente(cliente);
			entityManager.persist(entity);
//			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

	@Override
	public Venda consultarComCollection(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery = 
				entityManager.createQuery(query);
		Venda venda = tpQuery.getSingleResult(); 
		return venda;
	}
	
//	@Override
//	public Collection<Venda> buscarTodos() throws DAOException {
//		StringBuilder sb = new StringBuilder();
//		sb.append("SELECT obj FROM ");
//		sb.append(this.persistenteClass.getSimpleName());
//		sb.append(" obj");
//		sb.append(" WHERE obj.status = :status");
//		TypedQuery<Venda> query = this.entityManager.createQuery(sb.toString(), Venda.class);
//		query.setParameter("status", Venda.Status.);
//		
//		List<T> list = 
//				entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
//		return list;
//	}

}
