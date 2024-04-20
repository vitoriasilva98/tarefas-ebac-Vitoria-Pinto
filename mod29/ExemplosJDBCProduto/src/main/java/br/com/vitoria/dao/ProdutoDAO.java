package br.com.vitoria.dao;

import br.com.vitoria.dao.jdbc.ConnectionFactory;
import br.com.vitoria.entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO tb_produto (descricao, codigo_de_barra, preco) VALUES (?, ?, ?)");
            stm = connection.prepareStatement(sql.toString());
            stm.setString(1, produto.getDescricao());
            stm.setString(2, produto.getCodigoDeBarra());
            stm.setDouble(3, produto.getPreco());

            return stm.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Erro ao cadastrar um produto: " + ex);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto buscarProduto(String codigoDeBarra) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM tb_produto WHERE codigo_de_barra LIKE ?");
            stm = connection.prepareStatement(sql.toString());
            stm.setString(1, codigoDeBarra);
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setProId(rs.getLong("pro_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigoDeBarra(rs.getString("codigo_de_barra"));
                produto.setPreco(rs.getDouble("preco"));
            }

            return produto;
        } catch (Exception ex) {
            throw new Exception("Erro ao buscar um produto: " + ex);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizarProduto(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE tb_produto SET descricao = ?, codigo_de_barra = ?, preco = ? WHERE pro_id = ?");
            stm = connection.prepareStatement(sql.toString());
            stm.setString(1, produto.getDescricao());
            stm.setString(2, produto.getCodigoDeBarra());
            stm.setDouble(3, produto.getPreco());
            stm.setLong(4, produto.getProId());

            return stm.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Erro ao atualizar um produto: " + ex);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluirProduto(String codigoDeBarra) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("DELETE FROM tb_produto WHERE codigo_de_barra LIKE ?");
            stm = connection.prepareStatement(sql.toString());
            stm.setString(1, codigoDeBarra);

            return stm.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Erro ao excluir um produto: " + ex);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> listarProdutos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        List<Produto> listaDeProdutos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_produto";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setProId(rs.getLong("pro_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigoDeBarra(rs.getString("codigo_de_barra"));
                produto.setPreco(rs.getDouble("preco"));
                
                listaDeProdutos.add(produto);
            }

            return listaDeProdutos;
        } catch (Exception ex) {
            throw new Exception("Erro ao buscar uma lista de produtos: " + ex);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
