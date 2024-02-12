package com.journaldev.spring.dao;

import com.journaldev.spring.model.Pizza;
import com.journaldev.spring.controller.PizzaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


public class PizzaSpringDataDAO {

    private PizzaRepository pizzaRepository = new PizzaRepository() {
        @PersistenceContext
        private EntityManager em;
        @Override
        public void delete(Pizza entity) {

        }

        @Override
        public List<Pizza> findAll() {
            return null;
        }

        @Override
        public List<Pizza> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Pizza> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public <S extends Pizza> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Pizza> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Pizza> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Pizza getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends Pizza> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Pizza> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Pizza> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Pizza> S save(S s) {
            return null;
        }

        @Override
        public Optional<Pizza> findById(Integer integer) {
            return null;
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        @Transactional
        public void deleteById(Integer integer) {
//            Pizza pizza = (Pizza) entity;
//            pizza.setDeleted(true);
//            em.persist(pizza);
        }

        @Override
        public void deleteAll(Iterable<? extends Pizza> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Pizza> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Pizza> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Pizza> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Pizza> boolean exists(Example<S> example) {
            return false;
        }
    };


    public PizzaSpringDataDAO() {
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
