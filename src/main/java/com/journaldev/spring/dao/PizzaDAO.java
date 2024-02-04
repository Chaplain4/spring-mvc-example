package com.journaldev.spring.dao;

import com.journaldev.spring.model.Emp;
import com.journaldev.spring.model.Pizza;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PizzaDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Pizza p) {
        String sql = "insert into pizzas(name,size,price) values('" + p.getName() + "'," + p.getSize() + ",'" + p.getPrice() + "')";
        return template.update(sql);
    }

    public int update(Pizza p) {
        String sql = "update pizzas set name='" + p.getName() + "', size=" + p.getSize() + ",price='" + p.getPrice() + "' where id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from pizzas where id=" + id + "";
        return template.update(sql);
    }

    public Pizza getPizzaById(int id) {
        String sql = "select * from pizzas where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Pizza>(Pizza.class));
    }

    public List<Pizza> getAll() {
        return template.query("select * from pizzas", new RowMapper<Pizza>() {
            public Pizza mapRow(ResultSet rs, int row) throws SQLException {
                Pizza p = new Pizza();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setSize(rs.getInt(3));
                p.setPrice(rs.getDouble(4));
                return p;
            }
        });
    }
}
