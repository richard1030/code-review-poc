package com.performetriks.code_review_poc.repository;

import com.performetriks.code_review_poc.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    public List<Customer> findAll() {
        return List.of(
                new Customer(1L, "John Smith", "john@example.com"),
                new Customer(2L, "Jane Doe", "jane@example.com")
        );
    }
}