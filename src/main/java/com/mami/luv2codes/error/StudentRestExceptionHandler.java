package com.mami.luv2codes.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<StudentResponseError> handleException(StudentNotFoundException e) {

    // Create new Student response error

    StudentResponseError studentResponseError = new StudentResponseError();
    studentResponseError.setStatus(HttpStatus.NOT_FOUND.value());
    studentResponseError.setMessage(e.getMessage());
    studentResponseError.setTimeStamp(System.currentTimeMillis());

    //Return response entity
    return new ResponseEntity<>(studentResponseError,HttpStatus.NOT_FOUND);


  }
  @ExceptionHandler
  public ResponseEntity<StudentResponseError> handleException(Exception e) {

    StudentResponseError studentResponseError = new StudentResponseError();
    studentResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
    studentResponseError.setMessage(e.getMessage());
    studentResponseError.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(studentResponseError,HttpStatus.BAD_REQUEST);

  }

}
