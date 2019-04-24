package com.sales.services;

import com.sales.models.Book;
import com.sales.repositories.BookRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    Book Service
 */

@Service
public class BookService {

    @Autowired
    BookRepoInterface bi;

    public void save(Book b) {
        bi.save(b);
    }

    public Iterable<Book> getBooks() {
        // Passing call onto CustomerRepository
        return bi.findAll();
    }
}
