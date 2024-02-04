package com.journaldev.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "pizzas")
public class Pizza {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "size", nullable = true)
    private int size;
    @Column(name = "price", nullable = true)
    private double price;
}
