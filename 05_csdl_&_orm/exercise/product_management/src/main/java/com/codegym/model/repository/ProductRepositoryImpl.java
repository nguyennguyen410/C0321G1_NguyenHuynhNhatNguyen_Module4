package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT c FROM Product AS c";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        Product product;
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        product =  query.getSingleResult();

        entityManager.remove(product);
    }

    @Override
    public Product findByName(String name) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.name = :name";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
