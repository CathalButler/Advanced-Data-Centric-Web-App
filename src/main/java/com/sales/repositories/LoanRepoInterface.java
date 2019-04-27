package com.sales.repositories;

import com.sales.models.Loan;
import org.springframework.data.repository.CrudRepository;

/*
    Loan module interface
 */

public interface LoanRepoInterface extends CrudRepository<Loan, Long> {

}
