package com.sales.controllers;

import com.sales.models.Loan;
import com.sales.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

/*
   Controller for Loans.
 */
@Controller
@SessionAttributes({"loan"})
public class LoanController {

    @Autowired
    LoanService loanService;

    // == Loan Methods ===================================================================

    /*
  Method to create a new loan object
  Request mapping /newLoan.
  Return newLoan page
   */
    @RequestMapping(value = "/newLoan", method = RequestMethod.GET)
    public String addLoan(Model model) {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "newLoan";
    }

    /*
  Method to add a new loan object to the database
  Request mapping /addCustomer.
  Redirect /showCustomers
   */
    @RequestMapping(value = "/newLoan", method = RequestMethod.POST)
    public String addLoanPost(@Valid @ModelAttribute("loan") Loan loan, BindingResult result) {
        // If input has an error, return to newLoan page
        if (result.hasErrors()) {
            return "newLoan";
        } else {// End if
            loanService.save(loan);
            return "redirect:showLoans";
        }// End if else
    }// End method


    /*
  Method to get all loan entry's from the database and store them in a list of loan objects
  Request mapping /showCustomers.
  return /showCustomers
   */
    @RequestMapping(value = "/showLoans")
    public String getLoans(Model model) {
        // List of book objects
        List<Loan> loans = (List<Loan>) loanService.getLoans();
        // Create objects from model book and all to the array list
        model.addAttribute("loans", loans);

        return "showLoans";
    }// End getBooks method

    @RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
    public String getDeleteLoan(Model m) {
        Loan loan = new Loan();
        m.addAttribute("loan", loan);
        return "deleteLoan";
    }

    @RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
    public String deleteLoan(@Valid @ModelAttribute("loan") Loan loan, BindingResult result) {
        // If input has an error, return to newLoan page
        if (result.hasErrors()) {
            return "newLoan"; //return to a new page if error
        } else {// End if
            loanService.deleteLoanByLid(loan.getLid());
            return "redirect:showLoans";
        }// End if else
    }// End method
}
