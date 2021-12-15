package com.mami.luv2codes.controller;


import com.mami.luv2codes.entity.Student;
import com.mami.luv2codes.error.StudentNotFoundException;
import com.mami.luv2codes.error.StudentResponseError;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> theStudents;

  @PostConstruct
  public void init() {

   theStudents = Arrays.asList(
        new Student("asd","fgh"),
        new Student("rty","fjkl"),
        new Student("hjj","ytu"),
        new Student("hjk","yuiop") );

  };


  @GetMapping("/students")
  public  List<Student> getStudents() {

   return theStudents;

  }

  @GetMapping("/students/{id}")
  public Student getById(@PathVariable int id) throws StudentNotFoundException {

    if(id<0 || id >= theStudents.size()) {
      throw new StudentNotFoundException("Student id not found " + id);
    }

    return theStudents.get(id);
  }

}
