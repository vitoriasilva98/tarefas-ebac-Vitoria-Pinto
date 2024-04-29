
package br.com.vitoria.service;

import java.util.List;

import br.com.vitoria.domain.Produto;
import br.com.vitoria.services.generic.IGenericService;

/**
 * @author vitoria.vitoria
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
