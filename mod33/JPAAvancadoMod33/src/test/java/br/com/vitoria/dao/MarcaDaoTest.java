package br.com.vitoria.dao;

import br.com.vitoria.entity.Acessorio;
import br.com.vitoria.entity.Carro;
import br.com.vitoria.entity.Marca;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class MarcaDaoTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public MarcaDaoTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {

        Marca marca = criarMarca("Fiat");
        Marca marca2 = criarMarca("Volkswagean");

        Carro carro1 = criarCarro("Argo", "Preto", marca);
        Carro carro2 = criarCarro("Fox", "Vermelho", marca2);

        criarAcessorio("Suporte para celular", carro1);
        criarAcessorio("Protetor Solar Parabrisa", carro1);
        criarAcessorio("Protetor Solar Parabrisa", carro2);

        assertNotNull(marca);
        assertNotNull(marca2);
        assertNotNull(marca.getMarId());

        List<Marca> listaDeMarcas = marcaDao.listarMarcas();

        assertNotNull(listaDeMarcas);
    }

    private Marca criarMarca(String nome) {
        Marca marca = new Marca();
        marca.setNome(nome);
        marcaDao.cadastrar(marca);
        return marca;
    }

    private Acessorio criarAcessorio(String descricao, Carro carro) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(descricao);
        acessorio.setCarro(carro);
        return acessorioDao.cadastrar(acessorio);
    }

    private Carro criarCarro(String modelo, String cor, Marca marca) {
        Carro carro = new Carro();
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setCor(cor);
        return carroDao.cadastrar(carro);
    }
}
