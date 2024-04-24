package br.com.vitoria.dao;

import br.com.vitoria.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProdutoDao implements IProdutoDao {

    private EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

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
    public Produto cadastrar(Produto produto) {
        this.init();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        this.end();

        return produto;
    }

    @Override
    public Produto consultar(Long proId) {
        this.init();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Produto p ");
        sb.append("WHERE p.proId = :proId");

        TypedQuery<Produto> query = entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("proId", proId);

        Produto produto = query.getSingleResult();
        this.end();

        return produto;
    }

    @Override
    public List<Produto> listarProdutos() {
        this.init();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        query.select(root);

        TypedQuery<Produto> tpQuery = entityManager.createQuery(query);
        List<Produto> list = tpQuery.getResultList();

        return list;
    }

    @Override
    public void excluir(Produto produto) {
        this.init();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
        this.end();
    }
}
