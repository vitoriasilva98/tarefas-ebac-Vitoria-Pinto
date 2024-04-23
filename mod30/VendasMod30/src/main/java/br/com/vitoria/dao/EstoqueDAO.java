package br.com.vitoria.dao;

import br.com.vitoria.dao.factory.EstoqueFactory;
import br.com.vitoria.dao.generic.GenericDAO;
import br.com.vitoria.domain.Estoque;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.MaisDeUmRegistroException;
import br.com.vitoria.exceptions.TableException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EstoqueDAO extends GenericDAO<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setId(entity.getId());
        entityCadastrado.setProduto(entity.getProduto());
        entityCadastrado.setUnidade(entity.getUnidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(ID, id_produto_fk, UNIDADE) ");
        sb.append("VALUES (nextval('sq_produto'),?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE id_produto_fk = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_ESTOQUE ");
        sb.append("SET UNIDADE = ?,");
        sb.append(" WHERE id_produto_fk = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getProduto().getId());
        stmInsert.setInt(2, entity.getUnidade());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
        stmDelete.setLong(1, Long.valueOf(valor));
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setLong(1, entity.getProduto().getId());
        stmUpdate.setInt(2, entity.getUnidade());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
        stmUpdate.setLong(1, Long.valueOf(valor));
    }

    @Override
    public Integer verificarQuantidadeDoProdutoNoEstoque(Long produtoId) throws Exception {

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT est.unidade FROM TB_ESTOQUE est ");
            sql.append("INNER JOIN TB_PRODUTO pro ON pro.id = est.id_produto_fk ");
            sql.append("WHERE est.id_produto_fk  = ?");

            connection = getConnection();
            stm = connection.prepareStatement(sql.toString());
            stm.setLong(1, produtoId);
            rs = stm.executeQuery();

            if (rs.next()) {
                return rs.getInt("unidade");
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO AO BUSCAR QUANTIDADE DE PRODUTOS NO ESTOQUE ", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
        return null;
    }

    public void atualizarEstoque(Long produtoId, Integer qtdAtualizada) throws Exception {
        Connection connection = getConnection();
        PreparedStatement stm = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TB_ESTOQUE SET UNIDADE = ? WHERE id_produto_fk = ?");

            stm = connection.prepareStatement(sql.toString());
            stm.setInt(1, qtdAtualizada);
            stm.setLong(2, produtoId);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("ERRO ALTERANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Collection<Estoque> buscarTodos() throws DAOException {
        List<Estoque> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT pro.id as ID_PRODUTO, pro.codigo, pro.nome, pro.descricao, pro.valor, pro.marca, ");
        sb.append("est.id, est.id_produto_fk, est.unidade ");
        sb.append("FROM TB_ESTOQUE est ");
        sb.append("INNER JOIN TB_PRODUTO pro ON pro.id = est.id_produto_fk ");

        try {
            Connection connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(sb.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Estoque estoque = EstoqueFactory.convert(rs);
                lista.add(estoque);
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        }
        return lista;
    }

    @Override
    public Estoque consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pro.id as ID_PRODUTO, pro.codigo, pro.nome, pro.descricao, pro.valor, pro.marca, est.id, est.unidade  ");
        sql.append(" FROM TB_ESTOQUE est ");
        sql.append(" INNER JOIN TB_PRODUTO pro ON pro.id = est.id_produto_fk ");
        sql.append("WHERE est.id_produto_fk = ? ");
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            connection = getConnection();
            stm = connection.prepareStatement(sql.toString());
            setParametrosQuerySelect(stm, valor);
            rs = stm.executeQuery();
            if (rs.next()) {
                Estoque estoque = EstoqueFactory.convert(rs);
                return estoque;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
        return null;

    }
}
