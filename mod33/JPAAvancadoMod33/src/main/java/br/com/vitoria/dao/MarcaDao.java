package br.com.vitoria.dao;

import br.com.vitoria.entity.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MarcaDao implements IMarcaDao {

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
    public Marca cadastrar(Marca marca) {
        this.init();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();
        this.end();

        return marca;
    }

    @Override
    public Marca buscarMarcaPorNome(String marca) {
        this.init();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM marca m ");
        sb.append("WHERE m.nome = :marca");

        TypedQuery<Marca> query = entityManager.createQuery(sb.toString(), Marca.class);
        query.setParameter("marca", marca);

        Marca produto = query.getSingleResult();
        this.end();

        return produto;
    }

    @Override
    public List<Marca> listarMarcas() {
        this.init();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Marca> query = builder.createQuery(Marca.class);
        Root<Marca> root = query.from(Marca.class);
        query.select(root);

        TypedQuery<Marca> tpQuery = entityManager.createQuery(query);
        List<Marca> list = tpQuery.getResultList();

        return list;
    }

    @Override
    public void excluirMarca(Marca marca) {
        this.init();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();
        this.end();
    }

}
