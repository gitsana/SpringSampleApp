package com.pluralsight.repository;

import com.pluralsight.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// hide actual implementation from our code
// stub
@Repository("customerRepository") // name this as same as interface but with lower-case of interface
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${theFirstName}")
    private String firstName;

    @Value("${theLastName}")
    private String lastName;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setFirstname(firstName);
        customer.setLastname(lastName);
        customers.add(customer);
        return customers;
    }
}
