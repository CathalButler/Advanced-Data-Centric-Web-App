package com.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
   Class that will handle MySQL Exceptions
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate entry")
public class UserDefinedException extends RuntimeException {
    public UserDefinedException(String message) {
        super(message);
    }// End constructor
}// End class
