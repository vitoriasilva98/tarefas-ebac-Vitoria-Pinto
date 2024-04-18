package br.com.vitoria;

import br.com.vitoria.dao.ClienteDAO;
import br.com.vitoria.dao.IClienteDAO;
import br.com.vitoria.domain.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteDAOTeste {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("C1");
        cliente.setNome("Vitória");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.buscar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }
}
