package br.com.vitoria;

import br.com.vitoria.dao.ContratoDao;
import br.com.vitoria.dao.IClienteDao;
import br.com.vitoria.dao.IContratoDao;
import br.com.vitoria.dao.mocks.ContratoDaoMock;
import br.com.vitoria.service.ContratoService;
import br.com.vitoria.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Contrato salvo com sucesso!", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Contrato salvo com sucesso!", retorno);
    }

    @Test
    public void idNuloAoBuscarContrato() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Assert.assertEquals("Id do contrato não pode ser nulo", service.buscar(null));
    }

    @Test
    public void esperandoEncontrarContratoMilionario() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Assert.assertEquals("Contrato milionário", service.buscar(1));
    }

    @Test
    public void idInexistenteAoBuscarContrato() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Assert.assertEquals("Id do contrato não encontrado!", service.buscar(2));
    }

    @Test
    public void exclusaoBemSucedida() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Assert.assertEquals("Contrato excluido com sucesso!", service.excluir(1));
    }

    @Test
    public void atualizacaoBemSucedida() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Assert.assertEquals("Contrato atualizado com sucesso!", service.editar(1));
    }

}
