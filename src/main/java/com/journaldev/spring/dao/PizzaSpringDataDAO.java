package com.journaldev.spring.dao;

import com.journaldev.spring.model.Pizza;
import com.journaldev.spring.controller.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public class PizzaSpringDataDAO {

    private final PizzaRepository pizzaRepository;


    public PizzaSpringDataDAO(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void save(Pizza p) {
        pizzaRepository.save(p);
    }

    public int update(Pizza p) {
            Pizza existingPizza = pizzaRepository.findById(p.getId()).orElse(null);
            if (existingPizza != null) {
                existingPizza.setName(p.getName());
                existingPizza.setSize(p.getSize());
                existingPizza.setPrice(p.getPrice());
                pizzaRepository.save(existingPizza);
                return 1;
            }
            else return -1;
    }

    public void delete(int id) {
        Pizza existingPizza = pizzaRepository.findById(id).orElse(null);
        if (existingPizza != null) {
            pizzaRepository.delete(existingPizza);
        }
    }

    public Pizza getPizzaById(int id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

}
