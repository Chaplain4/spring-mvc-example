package com.journaldev.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private int id;
    private String name;
    private float salary;
    private String designation;
}
