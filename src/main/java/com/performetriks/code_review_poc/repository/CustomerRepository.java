package com.performetriks.code_review_poc.repository;

import com.performetriks.code_review_poc.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        String sql = "SELECT ID, NAME, EMAIL FROM CUSTOMER";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Customer(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL")
                )
        );
    }

    public List<Customer> searchByName(String name) {

        String sql = "SELECT ID, NAME, EMAIL FROM CUSTOMER WHERE NAME = '" + name + "'";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Customer(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL")
                )
        );
    }
}