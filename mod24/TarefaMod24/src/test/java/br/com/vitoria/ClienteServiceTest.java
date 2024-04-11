package br.com.vitoria;

import br.com.vitoria.dao.ClienteDao;
import br.com.vitoria.dao.ClienteDaoMock;
import br.com.vitoria.dao.IClienteDao;
import br.com.vitoria.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;


public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
