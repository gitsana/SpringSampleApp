package com.pluralsight.service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// name this as same as interface but with lower-case of interface
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("Using setter injection autowiring");
        this.customerRepository = customerRepository;
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("Using constructor injection autowiring");
        this.customerRepository = customerRepository;
    }

    public CustomerServiceImpl() {
    }
}
