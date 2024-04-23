package br.com.vitoria.dao.factory;

import br.com.vitoria.domain.Estoque;
import br.com.vitoria.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueFactory {

    public static Estoque convert(ResultSet rs) throws SQLException {
        Produto produto = ProdutoFactory.convert(rs);
        Estoque estoque = new Estoque();
        estoque.setId(rs.getLong("id"));
        estoque.setProduto(produto);
        estoque.setUnidade(rs.getInt("unidade"));

        return estoque;
    }
}
