package com.mami.luv2codes.error;

public class StudentNotFoundException extends Exception {

  public StudentNotFoundException(String message) {
    super(message);
  }

  public StudentNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentNotFoundException(Throwable cause) {
    super(cause);
  }
}
