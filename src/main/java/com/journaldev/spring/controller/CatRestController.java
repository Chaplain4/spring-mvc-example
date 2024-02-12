package com.journaldev.spring.controller;

import com.journaldev.spring.model.Cat;
import com.journaldev.spring.repo.CatRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

//@RestController
//@EnableWebMvc
public class CatRestController {
    private static final Logger logger = LogManager.getLogger(EmpController.class);

    @Autowired
    private CatRepository repo; //will inject dao from XML file


    @GetMapping("/cats")
    public List<Cat> cats() {
        List<Cat> cats = (List<Cat>) repo.findAll();
        return cats;
    }
}
