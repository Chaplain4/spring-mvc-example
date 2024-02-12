package com.journaldev.spring.controller;


import com.journaldev.spring.model.Pizza;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends BaseRepository <Pizza, Integer> {
}