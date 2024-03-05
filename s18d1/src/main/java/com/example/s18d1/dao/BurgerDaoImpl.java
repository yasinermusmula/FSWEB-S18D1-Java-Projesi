package com.example.s18d1.dao;

import com.example.s18d1.entity.Bread;
import com.example.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findBy(long id) {
       return entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b from Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> queryPrice = entityManager.createQuery("SELECT b FROM Burger b WHERE  b.price > : price ORDER BY  b.price DESC ", Burger.class);
        queryPrice.setParameter("price",price);
        return queryPrice.getResultList();
    }

    @Override
    public List<Burger> findByBread(Bread breadType) {
        TypedQuery<Burger> queryBread = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name DESC ", Burger.class);
        queryBread.setParameter("breadType",breadType);
        return queryBread.getResultList();
    }

    @Override
    public List<Burger> findByContent(String contents) {
        return null;
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(long id) {
        Burger foundBurger = entityManager.find(Burger.class,id);
        entityManager.remove(foundBurger);
        return foundBurger;
    }
}
