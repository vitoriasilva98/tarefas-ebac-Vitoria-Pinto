/**
 * 
 */
package br.com.vitoria;

import br.com.vitoria.dao.ClienteDaoMock;
import br.com.vitoria.dao.IClienteDAO;
import br.com.vitoria.domain.Cliente;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;
import br.com.vitoria.services.ClienteService;
import br.com.vitoria.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Vitória");
		cliente.setCidade("São Paulo");
		cliente.setEnd("Avendida");
		cliente.setEstado("SP");
		cliente.setNumero(25);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Vitória Vitoria");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Vitória Vitoria", cliente.getNome());
	}
}
