package com.mami.luv2codes.controller;

import com.mami.luv2codes.entity.Customer;
import com.mami.luv2codes.error.CustomerNotFoundException;
import com.mami.luv2codes.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

  //Autowire Service

  CustomerService customerService;

  public CustomerRestController(CustomerService customerService) {
    this.customerService = customerService;

  }


//Add mapping for Get

  @GetMapping("/customers")
  public List<Customer> getCustomers() {

    return customerService.getCustomers();
  }

  @GetMapping("/customers/{id}")
  public Customer getById(@PathVariable int id) {

    Customer theCustomer = customerService.getCustomer(id);

    if(theCustomer == null) {

      throw new CustomerNotFoundException("Customer id not found - " + id);
    }

    return theCustomer;
  }
}
