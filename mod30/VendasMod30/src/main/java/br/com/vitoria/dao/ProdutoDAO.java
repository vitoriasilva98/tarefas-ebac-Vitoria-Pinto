
package br.com.vitoria.dao;

import br.com.vitoria.dao.factory.ProdutoFactory;
import br.com.vitoria.dao.factory.VendaFactory;
import br.com.vitoria.dao.generic.GenericDAO;
import br.com.vitoria.domain.Estoque;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.domain.Venda;
import br.com.vitoria.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author vitoria.vitoria
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
        entityCadastrado.setMarca(entity.getMarca());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO ");
        sb.append("(ID, CODIGO, NOME, DESCRICAO, VALOR, MARCA)");
        sb.append("VALUES (nextval('sq_produto'),?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getValor());
        stmInsert.setString(5, entity.getMarca());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO ");
        sb.append("SET CODIGO = ?,");
        sb.append("NOME = ?,");
        sb.append("DESCRICAO = ?,");
        sb.append("VALOR = ?, ");
        sb.append("MARCA = ?");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setString(3, entity.getDescricao());
        stmUpdate.setBigDecimal(4, entity.getValor());
        stmUpdate.setString(5, entity.getMarca());
        stmUpdate.setString(6, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    public Collection<Produto> buscarTodos() throws DAOException {
        List<Produto> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT pro.id as ID_PRODUTO, pro.codigo, pro.nome, pro.descricao, pro.valor, pro.marca FROM TB_PRODUTO pro");

        try {
            Connection connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(sb.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Produto produto = ProdutoFactory.convert(rs);
                lista.add(produto);
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        }
        return lista;
    }
}
