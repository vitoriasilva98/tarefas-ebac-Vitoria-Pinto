package br.com.vitoriapinto.domain;

public class Produto {
    private Long codigoBarra;
    private String nome;
    private String marca;
    private Double preco;

    public Produto(Long codigoBarra, String nome, String marca, Double preco) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public Long getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(Long codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
                "codigoBarra=" + codigoBarra +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                '}';
    }
}
