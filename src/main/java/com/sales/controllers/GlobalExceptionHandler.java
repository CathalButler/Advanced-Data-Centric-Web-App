package com.sales.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/*
    Handlers used for global exceptions in the application.
    @ControllerAdvice
    Link: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    // Logger for spring console
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * ExceptionHandler for SQLException class
     *
     * @param ex
     * @param request
     * @return returns a webpage
     * @Desc exceptions are logged and the method returns the databases error page.
     **/
    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
        logger.info("SQLException Occurred: URL=" + request.getRequestURL());
        return "databaseError";
    }// End method

    /**
     * ExceptionHandler for SQLException class
     *
     * @Desc exceptions are logged.
     **/
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occurred")
    @ExceptionHandler(IOException.class)
    public void handleIOException() {
        logger.error("IOException handler executed");
        //returning 404 error code
    }// End method
}// End class
