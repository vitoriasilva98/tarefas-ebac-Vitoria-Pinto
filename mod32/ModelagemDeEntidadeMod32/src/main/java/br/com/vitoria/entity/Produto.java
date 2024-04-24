package br.com.vitoria.entity;

import javax.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
    private Long proId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_de_barra", nullable = false, unique = true)
    private String codigoDeBarra;

    @Column(name = "preco", nullable = false)
    private Double preco;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
