package br.com.vitoria.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    @Column(name = "car_id")
    private Long carId;

    @ManyToOne
    @JoinColumn(name = "mar_id", foreignKey = @ForeignKey(name = "fk_marca"),
            referencedColumnName = "mar_id", nullable = false)
    private Marca marca;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "cor", length = 50, nullable = false)
    private String cor;

    @OneToMany(mappedBy = "carro")
    private List<Acessorio> acessorios;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
