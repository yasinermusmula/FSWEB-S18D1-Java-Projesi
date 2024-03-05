package com.example.s18d1.controller;


import com.example.s18d1.dao.BurgerDao;
import com.example.s18d1.dao.BurgerDaoImpl;
import com.example.s18d1.entity.Burger;
import com.example.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @PostMapping("/burgers")
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.isNameExist(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping("/burgers")
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/burgers/{id}")
    public Burger findById(@PathVariable("id") long burgerId){
        return burgerDao.findBy(burgerId);
    }

    @PutMapping("/burgers/{id}")
    public Burger update(@PathVariable("id") long id, @RequestBody Burger burger ){
        burger.setId(id);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/burgers/{id}")
    public Burger delete(@PathVariable("id") long burgerId)  {
        return burgerDao.remove(burgerId);
    }

}
