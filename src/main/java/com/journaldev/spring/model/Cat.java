package com.journaldev.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = true)
    private String name;
}
