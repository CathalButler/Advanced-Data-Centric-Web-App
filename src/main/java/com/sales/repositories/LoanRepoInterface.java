package com.sales.repositories;

import com.sales.models.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepoInterface extends CrudRepository<Loan, Long> {


}
