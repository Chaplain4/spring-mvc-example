package com.journaldev.spring.service;

import com.journaldev.spring.model.Customer;
import com.journaldev.spring.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1L, "Sherlock Holmes", "Sherlock@gmail.com", "London, Baker st., 221B"));
        customerList.add(new Customer(2L, "Dr. John H. Watson", "Watson@gmail.com", "London, Baker st., 221B"));
        customerList.add(new Customer(3L, "Mycroft Holmes", "Mycroft@gmail.com", "London, Fleet st., 49"));
    }

    @Override
    public List<Customer> listAll() {
        return customerList;
    }

    @Override
    public boolean save(Customer customer) {
        if (get(customer.getId()) == null) {
            customer.setId((long) (customerList.size() + 1));
            customerList.add(customer);
            return true;
        } else {
            delete(customer.getId());
            customerList.add(customer);
            return false;
        }
    }

    @Override
    public Customer get(Long id) {
        Customer c = new Customer();
        customerList.forEach(customer -> {
            if (customer.getId().equals(id)) {
                c.setId(customer.getId());
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setAddress(customer.getAddress());
            }
        });
        if (c.getId() != null)
            return c;
        else
            return null;
    }

    @Override
    public boolean delete(Long id) {
        Customer c = new Customer();
        customerList.forEach(customer -> {
            if (customer.getId().equals(id)) {
                c.setId(customer.getId());
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setAddress(customer.getAddress());
            }
        });
        if (c.getId() != null) {
            customerList.remove(c);
            return true;
        } else
            return false;
    }

    @Override
    public List<Customer> search(String keyword) {
        List<Customer> c = new ArrayList<>();
        customerList.forEach(customer -> {
            if (customer.getName().contains(keyword) || customer.getAddress().contains(keyword) || customer.getEmail().contains(keyword)) {
                c.add(customer);
            }
        });
        return c;
    }
}
