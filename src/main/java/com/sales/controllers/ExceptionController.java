package com.sales.controllers;

import com.sales.exceptions.DeleteException;
import com.sales.exceptions.UserDefinedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
    User Defined Exception handlers used for user exceptions in the application.
    @ControllerAdvice
    Link: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html
 */

@ControllerAdvice
public class ExceptionController {
    // Logger for Spring console
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * ExceptionHandler for UserDefinedException class
     *
     * @param ex
     * @param req
     * @return returns ModelAndView Object with error message and error heading.
     * @Desc exception error for UserDefinedExceptions are passed into a ModelAndView with the url link .
     **/
    @ExceptionHandler(value = UserDefinedException.class)
    public ModelAndView handleUserException(UserDefinedException ex, HttpServletRequest req) {
        // Log to the spring console
        logger.error("Requested URL=" + req.getRequestURL());
        logger.error("Exception Raised=" + ex);
        // Generate corresponding results based on exception.
        ModelAndView m = new ModelAndView();
        // Add error message and url link
        m.addObject("error_heading", "Could not create New Loan");
        m.addObject("error", ex.getMessage());
        m.addObject("url", req.getRequestURL());
        // Set page to view
        m.setViewName("errorPage");
        return m;
    }// End

    /**
     * ExceptionHandler for DeleteException class
     *
     * @param ex
     * @param req
     * @return returns ModelAndView Object with error message and error heading.
     * @Desc exception error for UserDefinedExceptions are passed into a ModelAndView with the url link .
     **/
    @ExceptionHandler(value = DeleteException.class)
    public ModelAndView handleDeleteException(DeleteException ex, HttpServletRequest req) {
        // Log to the spring console
        logger.error("Requested URL=" + req.getRequestURL());
        logger.error("Exception Raised=" + ex);
        // Generate corresponding results based on exception.
        ModelAndView m = new ModelAndView();
        // Add error message and url link
        m.addObject("error_heading", "Could not delete Loan");
        m.addObject("error", ex.getMessage());
        m.addObject("url", req.getRequestURL());
        // Set page to view
        m.setViewName("errorPage");
        return m;
    }// End

}// End class
