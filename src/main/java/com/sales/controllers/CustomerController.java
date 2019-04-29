package com.sales.controllers;

import com.sales.models.Customer;
import com.sales.services.CustomerService;
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

@Controller
@SessionAttributes({"customer"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // == Customer Methods ===========================================================

    /*
   Method to create a customer object
   Request mapping /addBook.
   Return addBook page
    */
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        System.out.println("Customer name: " + customer.getcName());
        return "addCustomer";
    }

    /*
  Method to add a new customer object to the database
  Request mapping /addCustomer.
  Redirect /showCustomers
   */
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        // If input has an error, return to addCustomer page
        if (result.hasErrors()) {
            return "addCustomer";
        } else {// End if
            System.out.println("Customer name: " + customer.getcName());
            customerService.save(customer);
            return "redirect:showCustomers";
        }
    }

    /*
   Method to get all customer entry's from the database and store them in a list of customer objects
   Request mapping /showCustomers.
   return /showCustomers
    */
    @RequestMapping(value = "/showCustomers")
    public String getCustomers(Model m) {
        // List of book objects
        List<Customer> customers = (List<Customer>) customerService.getCustomers();
        // Create objects from model book and all to the array list
        m.addAttribute("customers", customers);
        //Create objects from model loan and add to the array list
        return "showCustomers";
    }// End getBooks method

    // == End Customer Methods ===========================================================

}// End controller class
