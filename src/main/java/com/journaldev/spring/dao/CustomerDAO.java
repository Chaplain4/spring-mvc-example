package com.journaldev.spring.dao;

import com.journaldev.spring.model.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Customer p) {
        String sql = "insert into customers(name,email,address) values('" + p.getName() + "','" + p.getEmail() + "','" + p.getAddress() + "')";
        return template.update(sql);
    }

    public int update(Customer p) {
        String sql = "update customers set name='" + p.getName() + "', email='" + p.getEmail() + "',address='" + p.getAddress() + "' where id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from customers where id=" + id + "";
        return template.update(sql);
    }

    public Customer getEmpById(int id) {
        String sql = "select * from customers where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> getCustomers() {
        return template.query("select * from customers", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer e = new Customer();
                e.setId(rs.getLong(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setAddress(rs.getString(4));
                return e;
            }
        });
    }

    public List<Customer> search(String keyword) {
        List<Customer> all = getCustomers();
        List<Customer> result = new ArrayList<>();
        for (Customer c : all) {
            if (c.getAddress().contains(keyword) || c.getName().contains(keyword) || c.getEmail().contains(keyword)) {
                result.add(c);
            }
        }
        return result;
    }
}

