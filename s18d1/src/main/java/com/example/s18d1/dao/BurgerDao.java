package com.example.s18d1.dao;

import com.example.s18d1.entity.Bread;
import com.example.s18d1.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);

    Burger findBy(long id);

    List<Burger> findAll();

    List<Burger> findByPrice(double price);

    List<Burger> findByBread (Bread breadType);

    List<Burger> findByContent(String contents);

    Burger update(Burger burger);

    Burger remove(long id);

}
