package com.sales.repositories;

import com.sales.models.Loan;
import org.springframework.data.repository.CrudRepository;

/*
    Loan module interface
 */

public interface LoanRepoInterface extends CrudRepository<Loan, Long> {
    public Loan findLoanByCust_CIdAndBook_Bid(Long cid, Long bid);
    void deleteLoanByLid(Long lid);
}
