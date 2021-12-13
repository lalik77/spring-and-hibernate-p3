package com.mami.luv2codes.controller;


import com.mami.luv2codes.entity.Student;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {


  @GetMapping("/students")
  public  List<Student> getStudents() {

    List<Student> list = Arrays.asList(
        new Student("asd","fgh"),
        new Student("rty","fjkl"),
        new Student("hjj","ytu"),
        new Student("hjk","yuiop")

    );

    System.out.println(list);

    return list;
  }
}
