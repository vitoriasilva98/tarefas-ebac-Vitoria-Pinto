package br.com.vitoria;

import br.com.vitoria.dao.IProdutoDao;
import br.com.vitoria.dao.ProdutoDao;
import br.com.vitoria.entity.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setNome("caneta");
        produto.setCodigoDeBarra("CANAZUL");
        produto.setPreco(2.50);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getProId());
    }

    @Test
    public void consultar() {
        Produto produto = criarProduto("Caneta", "CANETAPRETA", 2.50);

        assertNotNull(produto);
        assertNotNull(produto.getProId());

        Produto produtoBD = produtoDao.consultar(produto.getProId());
        assertNotNull(produtoBD);
        assertEquals(produto.getProId(), produtoBD.getProId());
    }


    @Test
    public void listarProdutos() {
        criarProduto("Caneta", "CANAZUL", 2.50);
        criarProduto("Caneta", "CANETAPRETA", 2.50);
        criarProduto("Caneta", "CANETAVERMELHA", 2.50);
        List<Produto> listaProdutosBD = produtoDao.listarProdutos();

        assertNotNull(listaProdutosBD);
        assertEquals(3, listaProdutosBD.size());
    }

    @Test
    public void excluir() {
        criarProduto("Caneta", "CANAZUL", 2.50);
        criarProduto("Caneta", "CANETAPRETA", 2.50);
        criarProduto("Caneta", "CANETAVERMELHA", 2.50);
        Produto produto = criarProduto("Caneta", "CANETAVERDE", 2.50);

        List<Produto> listaProdutosBD = produtoDao.listarProdutos();

        assertEquals(4, listaProdutosBD.size());

        produtoDao.excluir(produto);
        produtoDao.excluir(listaProdutosBD.get(2));

        List<Produto> listaProdutosAtualizadaBD = produtoDao.listarProdutos();
        assertNotNull(listaProdutosAtualizadaBD);
        assertEquals(2, listaProdutosAtualizadaBD.size());
    }

    private Produto criarProduto(String nome, String codigoDeBarra, Double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setCodigoDeBarra(codigoDeBarra);
        produto.setPreco(preco);
        return produtoDao.cadastrar(produto);
    }

    @After
    public void end() {
        List<Produto> list = produtoDao.listarProdutos();
        list.forEach(prod -> produtoDao.excluir(prod));
    }

}
