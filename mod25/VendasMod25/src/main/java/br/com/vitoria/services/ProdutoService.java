/**
 * 
 */
package br.com.vitoria.services;

import br.com.vitoria.dao.IProdutoDAO;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.services.generic.GenericService;


public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
