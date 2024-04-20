package br.com.vitoria.entity;

public class Produto {

    private Long proId;
    private String descricao;
    private String codigoDeBarra;
    private Double preco;

    public Produto() {
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "proId=" + proId +
                ", descricao='" + descricao + '\'' +
                ", codigoDeBarra='" + codigoDeBarra + '\'' +
                ", preco=" + preco +
                '}';
    }
}
