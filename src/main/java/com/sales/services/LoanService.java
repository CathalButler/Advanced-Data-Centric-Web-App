package com.sales.services;

import com.sales.models.Loan;
import com.sales.repositories.LoanRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    LoanRepoInterface li;

    // Method to save loans
    public void save(Loan l) {
        li.save(l);
    }// End save

    // Method to get all customers
    public Iterable<Loan> getLoans() {
        // Passing call onto CustomerRepository
        return li.findAll();
    }// End getCustomers
}// End LoanService class
