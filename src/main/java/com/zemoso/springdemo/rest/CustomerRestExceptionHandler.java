package com.zemoso.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exe){
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exe.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exe){
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exe.getMessage(),
                System.currentTimeMillis()

        );

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }


}
