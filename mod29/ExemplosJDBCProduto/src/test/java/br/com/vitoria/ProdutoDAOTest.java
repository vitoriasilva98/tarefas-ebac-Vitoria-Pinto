package br.com.vitoria;

import br.com.vitoria.dao.ProdutoDAO;
import br.com.vitoria.dao.IProdutoDAO;
import br.com.vitoria.entity.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setDescricao("Caneta");
        produto.setCodigoDeBarra("CAN01");
        produto.setPreco(2.50);

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.buscarProduto(produto.getCodigoDeBarra());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getProId());
        assertEquals(produto.getCodigoDeBarra(), produtoBD.getCodigoDeBarra());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer qtdDel = produtoDAO.excluirProduto(produtoBD.getCodigoDeBarra());
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setDescricao("Caneta");
        produto.setCodigoDeBarra("CAN01");
        produto.setPreco(2.50);

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscarProduto("CAN01");
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getProId());
        assertEquals(produto.getCodigoDeBarra(), produtoBD.getCodigoDeBarra());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer countDel = produtoDAO.excluirProduto(produtoBD.getCodigoDeBarra());
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setDescricao("Marcador de texto");
        produto.setCodigoDeBarra("MARCATX02");
        produto.setPreco(4.50);

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscarProduto("MARCATX02");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigoDeBarra(), produtoBD.getCodigoDeBarra());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer countDel = produtoDAO.excluirProduto(produtoBD.getCodigoDeBarra());
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarProdutoTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setDescricao("Marcador de texto");
        produto.setCodigoDeBarra("MARCATX02");
        produto.setPreco(2.50);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto2 = new Produto();
        produto2.setDescricao("Caneta");
        produto2.setCodigoDeBarra("CAN01");
        produto2.setPreco(2.50);
        Integer countCad2 = produtoDAO.cadastrar(produto2);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.listarProdutos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto pro : list) {
            produtoDAO.excluirProduto(pro.getCodigoDeBarra());
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.listarProdutos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setDescricao("Marcador de texto");
        produto.setCodigoDeBarra("MARCATX02");
        produto.setPreco(2.50);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscarProduto("MARCATX02");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigoDeBarra(), produtoBD.getCodigoDeBarra());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        produtoBD.setDescricao("Marcador de texto - azul");
        produtoBD.setCodigoDeBarra("MARCATXZ02");
        produtoBD.setPreco(4.75);
        Integer countUpdate = produtoDAO.atualizarProduto(produtoBD);
        assertTrue(countUpdate == 1);

        Produto clienteBD1 = produtoDAO.buscarProduto("MARCATX02");
        assertNull(clienteBD1);

        Produto clienteBD2 = produtoDAO.buscarProduto("MARCATXZ02");
        assertNotNull(clienteBD2);
        assertEquals(produtoBD.getProId(), clienteBD2.getProId());
        assertEquals(produtoBD.getCodigoDeBarra(), clienteBD2.getCodigoDeBarra());
        assertEquals(produtoBD.getDescricao(), clienteBD2.getDescricao());
        assertEquals(produtoBD.getPreco(), clienteBD2.getPreco());

        List<Produto> list = produtoDAO.listarProdutos();
        for (Produto pro : list) {
            produtoDAO.excluirProduto(pro.getCodigoDeBarra());
        }
    }
}
