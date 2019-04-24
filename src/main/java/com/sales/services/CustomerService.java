package com.sales.services;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepoInterface ci;

    // Method to save customers
    public void save(Customer c) {
        ci.save(c);
    }// End save

    // Method to get all customers
    public Iterable<Customer> getCustomers() {
        // Passing call onto CustomerRepository
        return ci.findAll();
    }// End getCustomers

}//End CustomerService Class
