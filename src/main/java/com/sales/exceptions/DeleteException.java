package com.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
   Class that will handle MySQL Exceptions
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Could not delete Loan")
public class DeleteException extends RuntimeException {
    public DeleteException(String message) {
        super(message);
    }// End constructor
}// End class
