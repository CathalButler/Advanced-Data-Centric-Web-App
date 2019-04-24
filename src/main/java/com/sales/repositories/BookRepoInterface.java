package com.sales.repositories;

import com.sales.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    Books module interface
 */
@Repository
public interface BookRepoInterface extends CrudRepository<Book, Long> {

}
