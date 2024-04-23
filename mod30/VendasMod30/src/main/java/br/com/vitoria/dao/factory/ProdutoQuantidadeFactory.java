
package br.com.vitoria.dao.factory;

import br.com.vitoria.domain.Produto;
import br.com.vitoria.domain.ProdutoQuantidade;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author vitoria.vitoria
 *
 */
public class ProdutoQuantidadeFactory {

	public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
		Produto prod = ProdutoFactory.convert(rs);
		ProdutoQuantidade prodQ = new ProdutoQuantidade();
		prodQ.setProduto(prod);
		prodQ.setId(rs.getLong("ID"));
		prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
		prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodQ;
	}
}
