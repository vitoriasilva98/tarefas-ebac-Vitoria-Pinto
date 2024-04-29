
package br.com.vitoria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vitoria.dao.IProdutoDAO;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.services.generic.GenericService;

/**
 * @author vitoria.vitoria
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
