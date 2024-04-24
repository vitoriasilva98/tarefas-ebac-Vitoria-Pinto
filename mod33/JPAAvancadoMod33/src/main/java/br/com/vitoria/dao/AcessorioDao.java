package br.com.vitoria.dao;

import br.com.vitoria.entity.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessorioDao implements IAcessorioDao {

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
    public Acessorio cadastrar(Acessorio acessorio) {
        this.init();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();
        this.end();

        return acessorio;
    }
}
