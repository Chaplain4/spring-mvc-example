package com.journaldev.spring.dao;

import com.journaldev.spring.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(User u) {
        String sql = "insert into Users(first_name,last_name,login,password,email) values('" + u.getFirstName() + "', '  " + u.getLastName() + "', '" + u.getLogin() + "', '" + u.getPassword() + "','" + u.getEmail() + "')";
        return template.update(sql);
    }

    public int update(User u) {
        String sql = "insert into Users(first_name,last_name,login,password,email) values('" + u.getFirstName() + "', '  " + u.getLastName() + "', '" + u.getLogin() + "', '" + u.getPassword() + "','" + u.getEmail() + "')";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from users where id=" + id + "";
        return template.update(sql);
    }

    public User getUserById(int id) {
        String sql = "select * from users where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    public User getUserByLogin(String login) {
        try {
            String sql = "select * from users where login=?";
            return template.queryForObject(sql, new Object[]{login}, new BeanPropertyRowMapper<User>(User.class));
        } catch (Throwable t) {
            return null;
        }
    }

    public User getUserByEmail(String email) {
        String sql = "select * from users where email=?";
        return template.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> getAll() {
        return template.query("select * from users", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User p = new User();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setLogin(rs.getString(4));
                p.setPassword(rs.getString(5));
                p.setEmail(rs.getString(6));
                p.setActive(rs.getBoolean(7));
                return p;
            }
        });
    }
}
