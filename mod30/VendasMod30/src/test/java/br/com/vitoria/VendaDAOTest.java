
package br.com.vitoria;

import br.com.vitoria.dao.*;
import br.com.vitoria.dao.generic.jdbc.ConnectionFactory;
import br.com.vitoria.domain.Cliente;
import br.com.vitoria.domain.Estoque;
import br.com.vitoria.domain.Produto;
import br.com.vitoria.domain.Venda;
import br.com.vitoria.domain.Venda.Status;
import br.com.vitoria.exceptions.DAOException;
import br.com.vitoria.exceptions.MaisDeUmRegistroException;
import br.com.vitoria.exceptions.TableException;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Watchable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author vitoria.vitoria
 *
 */
public class VendaDAOTest {
	
	private IVendaDAO vendaDao;
	
	private IClienteDAO clienteDao;
	
	private IProdutoDAO produtoDao;

	private IEstoqueDAO estoqueDAO;

	private Cliente cliente;
	
	private Produto produto;
	
	public VendaDAOTest() {
		vendaDao = new VendaDAO();
		clienteDao = new ClienteDAO();
		produtoDao = new ProdutoDAO();
		estoqueDAO = new EstoqueDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);

		Estoque estoque = new Estoque();
		estoque.setProduto(this.produto);
		estoque.setUnidade(5);

		this.estoqueDAO.cadastrar(estoque);
	}
	
	@After
	public void end() throws DAOException {
		excluirVendas();
		excluirProdutos();
		clienteDao.excluir(this.cliente.getCpf());
	}


	private void excluirProdutos() throws DAOException {

		Collection<Estoque> listaEstoque = this.estoqueDAO.buscarTodos();
		for (Estoque estoque : listaEstoque) {
			this.estoqueDAO.excluir(estoque.getProduto().getId().toString());
		}

		Collection<Produto> list = this.produtoDao.buscarTodos();
		for (Produto prod : list) {
			this.produtoDao.excluir(prod.getCodigo());
		}
	}

	@Test
	public void pesquisar() throws Exception {
		Venda venda = criarVenda("A1");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void salvar() throws Exception {
		Venda venda = criarVenda("A2");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		
		assertFalse(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
		Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
		assertTrue(vendaConsultada.getId() != null);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	} 


	@Test
	public void cancelarVenda() throws Exception {
		String codigoVenda = "A3";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		vendaDao.cancelarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	@Test
	public void adicionarMaisProdutosDoMesmo() throws Exception {
		String codigoVenda = "A4";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(produto, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void adicionarMaisProdutosDiferentes() throws Exception {
		String codigoVenda = "A5";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test(expected = DAOException.class)
	public void salvarVendaMesmoCodigoExistente() throws Exception {
		Venda venda = criarVenda("A6");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
	
		Boolean retorno1 = vendaDao.cadastrar(venda);
		assertFalse(retorno1);
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerProduto() throws Exception {
		String codigoVenda = "A7";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerApenasUmProduto() throws Exception {
		String codigoVenda = "A8";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerTodosProdutos() throws Exception {
		String codigoVenda = "A9";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerTodosProdutos();
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
		assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.valueOf(0)));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void finalizarVenda() throws Exception {
		String codigoVenda = "A10";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		vendaDao.finalizarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws Exception {
		String codigoVenda = "A11";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		vendaDao.finalizarVenda(venda);
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProduto(this.produto, 1);
		
	}

	private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produto.setMarca("EBAC");
		produtoDao.cadastrar(produto);

		produto = produtoDao.consultar(codigo);

		return produto;
	}

	private Cliente cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Vitória");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("vitoria1@ebac.com");
		clienteDao.cadastrar(cliente);
		return cliente;
	}
	
	private Venda criarVenda(String codigo) throws Exception {
		Venda venda = new Venda();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);

		Integer quantidadeVenda = 2;

		venda.adicionarProduto(this.produto, quantidadeVenda);

		this.produtoDao.consultar("A1");

		Integer qtdDeProdutosNoEstoque = this.estoqueDAO.verificarQuantidadeDoProdutoNoEstoque(this.produto.getId());

		if(qtdDeProdutosNoEstoque != null) {
			if(qtdDeProdutosNoEstoque < 1 && qtdDeProdutosNoEstoque >= quantidadeVenda) {
				throw new Exception("Produto sem estoque ou quantidade para venda inferior a desejada");
			}
		} else {
			throw new Exception("A busca pela quantidade de produtos no estoque é nula");
		}

		Integer qtdEstoqueAtualizada = qtdDeProdutosNoEstoque - quantidadeVenda;

		this.estoqueDAO.atualizarEstoque(this.produto.getId(), qtdEstoqueAtualizada);

		return venda;
	}
	
	private void excluirVendas() throws DAOException {
		String sqlProd = "DELETE FROM TB_PRODUTO_QUANTIDADE";
		executeDelete(sqlProd);
		
		String sqlV = "DELETE FROM TB_VENDA";
		executeDelete(sqlV);
	}

	private void executeDelete(String sql) throws DAOException {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
    		connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.executeUpdate();
		    
		} catch (SQLException e) {
			throw new DAOException("ERRO EXLUINDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, rs);
		}
	}
	
	protected void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !stm.isClosed()) {
				connection.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws DAOException {
		try {
			return ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new DAOException("ERRO ABRINDO CONEXAO COM BANCO DE DADOS ", e);
		}
	}

}
