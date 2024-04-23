
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

import static org.junit.Assert.*;

/**
 * @author vitoria.vitoria
 *
 */
public class ProdutoDAOTest {
	
	private IProdutoDAO produtoDao;

	private IEstoqueDAO estoqueDAO;

	public ProdutoDAOTest() {
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

	private Produto criarProduto(String codigo, Integer unidadeEstoque) throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
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
		Produto produto = criarProduto("A1", 5);
		Assert.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
		Assert.assertNotNull(produtoDB);
		excluir(produtoDB.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A2", 8);
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3", 3);
		Assert.assertNotNull(produto);

		Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());

		estoqueDAO.excluir(produtoConsultado.getId().toString());

		excluir(produto.getCodigo());
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4",9);
		produto.setNome("Vitória");
		produtoDao.alterar(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		Assert.assertEquals("Vitória", produtoBD.getNome());
		
		excluir(produto.getCodigo());
		Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD1);
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		criarProduto("A5",3);
		criarProduto("A6",3);
		Collection<Produto> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (Produto prod : list) {
			excluir(prod.getCodigo());
		}
		
		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
}
