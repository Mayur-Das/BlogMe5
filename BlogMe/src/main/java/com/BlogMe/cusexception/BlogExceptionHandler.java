package com.BlogMe.cusexception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.NoSuchElementException;

@ControllerAdvice
public class BlogExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> NullPointerException(NullPointerException e){
        return new ResponseEntity<Object>(" No product found for this id ", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> NoSuchElementException(NoSuchElementException e){
        return new ResponseEntity<Object>("Sorry No product found for this id ", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> EmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return new ResponseEntity<Object>("Sorry This Id Not Present", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BlogException.class)
    public ResponseEntity<?> BlogException(BlogException e){
        return new ResponseEntity<Object>("No Data Avaialable", HttpStatus.BAD_REQUEST);
    }


}
