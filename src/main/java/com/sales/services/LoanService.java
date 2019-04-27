package com.sales.services;

import com.sales.exceptions.UserDefinedException;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class LoanService {

    @Autowired
    LoanRepoInterface li;

    // Method to save loans
    public void save(Loan l) {
        // Loan Peroid
        int loanDuration = l.getCust().getLoanPeriod();
        // Get localDate + loan Duration
        LocalDate date = LocalDate.now().plusDays(loanDuration);
        // Format localDate
        String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Set the Due date to the loan object
        l.setDueDate(formattedDate);
        // Save the object to the database
        try {
            li.save(l);
        } catch (Exception e) {
            // Already exists in the databases:
            throw new UserDefinedException("Book: " + l.getBook().getBid() + "(" + l.getBook().getTitle() + ")" +
                    "already on loan to Customer: " + l.getCust().getcId() + "(" + l.getCust().getcName() + ")");
        }

    }// End save

    public void deleteLoan(Loan l) {
        li.delete(l);
    }

    // Method to get all customers
    public Iterable<Loan> getLoans() {
        // Passing call onto CustomerRepository
        return li.findAll();
    }// End getCustomers
}// End LoanService class
