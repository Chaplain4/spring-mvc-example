package com.journaldev.spring.service;

import com.journaldev.spring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAll();

    boolean save(Customer customer);

    Customer get(Long id);

    boolean delete(Long id);

    List<Customer> search(String keyword);

}
