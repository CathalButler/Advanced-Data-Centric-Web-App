package com.sales.repositories;

import com.sales.models.Customer;
import org.springframework.data.repository.CrudRepository;

/*
    Customer module interface
 */

public interface CustomerRepoInterface extends CrudRepository<Customer, Long> {
}
