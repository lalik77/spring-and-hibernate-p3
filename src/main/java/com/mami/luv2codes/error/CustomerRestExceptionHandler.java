package com.mami.luv2codes.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {


  // add an exception handler for CustomerNotFoundException

  @ExceptionHandler
  public ResponseEntity<CustomerErrorMessage> handleException(CustomerNotFoundException e) {

    //create CustomerErrorResponse

    CustomerErrorMessage errorMessage = new CustomerErrorMessage(
        HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis()
    );
    // return ResponseEntity

    return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
  }

  // add another exception handler to catch any exception

  @ExceptionHandler
  public ResponseEntity<CustomerErrorMessage> handleException(Exception e) {

    //create CustomerErrorResponse

    CustomerErrorMessage errorMessage = new CustomerErrorMessage(
        HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis()
    );
    // return ResponseEntity

    return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
  }

}
