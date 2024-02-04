package com.journaldev.spring.controller;

import com.journaldev.spring.dao.PizzaDAO;
import com.journaldev.spring.model.Pizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public class PizzaRestController {
    private static final Logger logger = LogManager.getLogger(EmpController.class);

    @Autowired
    private PizzaDAO dao; //will inject dao from XML file


    @GetMapping("/JSONviewpizza")
    public List<Pizza> pizzas() {
        List<Pizza> pizzas = dao.getAll();
        return pizzas;
    }

    @GetMapping("/JSONviewpizzabyid")
    public Pizza pizzabyid(int id) {
        Pizza p = dao.getPizzaById(id);
        return p;
    }

    @PutMapping("/JSONsavepizza")
    public String put(@RequestBody Pizza p) {
        try {
            dao.save(p);
            logger.info("S = {}", p.toString() + " saved successfully");
        } catch (Throwable t) {
            logger.error("S = {}", p.toString() + "save error. Details: " + t.getMessage());
            return "error";
        }
        return "success";
    }


    @PostMapping("/JSONeditpizza")
    public String doPost(@RequestBody Pizza p) {
        try {
            int res = dao.update(p);
            logger.info("S = {}", p.toString() + " updated successfully");
        } catch (Throwable t) {
            logger.error("S = {}", p.toString() + "save error. Details: " + t.getMessage());
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/JSONdeletepizza")
    public String delete(@RequestParam int id) {
        try {
            dao.delete(id);
            logger.info("S = {}", "Pizza with id #" + id + " deleted successfully.");
        } catch (Throwable t) {
            logger.error("S = {}", "Pizza with id #" + id + " delete error. Details: " + t.getMessage());
            return "error";
        }
        return "success";
    }
}
