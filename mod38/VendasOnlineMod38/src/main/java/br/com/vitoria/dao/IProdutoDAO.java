
package br.com.vitoria.dao;

import java.util.List;

import br.com.vitoria.dao.generic.IGenericDAO;
import br.com.vitoria.domain.Produto;

/**
 * @author vitoria.vitoria
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
