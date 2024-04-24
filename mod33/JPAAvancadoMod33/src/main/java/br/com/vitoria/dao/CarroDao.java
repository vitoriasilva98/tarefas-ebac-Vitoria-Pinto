package br.com.vitoria.dao;

import br.com.vitoria.entity.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDao implements ICarroDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPAPersistence");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public void end() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Carro cadastrar(Carro carro) {
        this.init();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();
        this.end();

        return carro;
    }
}
