package com.sales.controllers;

import com.sales.models.Book;
import com.sales.services.BookService;
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
@SessionAttributes({"book"})
public class BookController {

    // Autowire for Services
    @Autowired
    BookService bookService;

    // == Book Methods ==============================================================
    /*
    Method to create a book object
    Request mapping /addBook.
    Return addBook page
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        System.out.println("Book Title: " + book.getTitle());
        return "addBook";
    }

    /*
    Method to add a new book object to the database
    Request mapping /addBook.
    Redirect /showBooks
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        // If input has an error, return to addBook page
        if (result.hasErrors()) {
            return "addBook";
        } else {// End if
            System.out.println("Book title: " + book.getTitle());
            bookService.save(book);
            return "redirect:showBooks";
        }
    }

    /*
    Method to get all book entry's from the database and store them in a list of book objects
    Request mapping /showBooks.
    return /showBooks
     */
    @RequestMapping(value = "/showBooks")
    public String getBooks(Model model) {
        // List of book objects
        List<Book> books = (List<Book>) bookService.getBooks();
        // Create objects from model book and all to the array list
        model.addAttribute("books", books);
        return "showBooks";
    }// End getBooks method

    // == End Book Methods ===========================================================
}
