package br.com.vitoria.entity;

import javax.persistence.*;

@Entity
@Table(name = "acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long aceId;

    @Column(name = "descricao" , length = 50, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "fk_carro"),
            referencedColumnName = "car_id", nullable = false)
    private Carro carro;

    public Long getAceId() {
        return aceId;
    }

    public void setAceId(Long aceId) {
        this.aceId = aceId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
