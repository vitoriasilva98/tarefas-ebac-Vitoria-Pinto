package br.com.vitoria.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import br.com.vitoria.dao.Persistente;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @TipoChave("getProduto")
    @ColunaTabela(dbName = "id_produto_fk", setJavaName = "setIdProdutoFk")
    private Produto produto;

    @ColunaTabela(dbName = "unidade", setJavaName = "setUnidade")
    private Integer unidade;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }
}
