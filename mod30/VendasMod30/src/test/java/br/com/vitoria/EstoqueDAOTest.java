package br.com.vitoria;

import br.com.vitoria.dao.EstoqueDAO;
import br.com.vitoria.dao.IEstoqueDAO;
import br.com.vitoria.dao.IProdutoDAO;
import br.com.vitoria.dao.ProdutoDAO;
import br.com.vitoria.domain.Estoque;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.MaisDeUmRegistroException;
import br.com.vitoria.exceptions.TableException;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

public class EstoqueDAOTest {

    private IProdutoDAO produtoDao;

    private IEstoqueDAO estoqueDAO;

    public EstoqueDAOTest() {
        produtoDao = new ProdutoDAO();
        estoqueDAO = new EstoqueDAO();
    }

    @After
    public void end() throws DAOException {

        Collection<Estoque> listaEstoque = this.estoqueDAO.buscarTodos();
        for (Estoque estoque : listaEstoque) {
            this.estoqueDAO.excluir(estoque.getProduto().getId().toString());
        }

        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDao.excluir(prod.getCodigo());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Produto criarEstoque(String codigo, Integer unidadeEstoque) throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("EBAC");
        produtoDao.cadastrar(produto);
        Produto produtoCadastrado = produtoDao.consultar(codigo);

        Estoque estoque = new Estoque();
        estoque.setProduto(produtoCadastrado);
        estoque.setUnidade(unidadeEstoque);
        estoqueDAO.cadastrar(estoque);

        return produto;
    }

    private void excluir(String valor) throws DAOException, MaisDeUmRegistroException, TableException {

        Produto produto = this.produtoDao.consultar(valor);
        this.estoqueDAO.excluir(produto.getId().toString());
        this.produtoDao.excluir(valor);
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = criarEstoque("A1", 5);
        Assert.assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoDB);
        excluir(produtoDB.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = criarEstoque("A2", 8);
        Assert.assertNotNull(produto);

        Estoque estoque = this.estoqueDAO.consultar(produto.getId().toString());

        Assert.assertNotNull(estoque);
        Assert.assertEquals(8, estoque.getUnidade().intValue());

        excluir(produto.getCodigo());
    }

}
