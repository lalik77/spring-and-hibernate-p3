package com.mami.luv2codes.controller;

import com.mami.luv2codes.entity.Customer;
import com.mami.luv2codes.error.CustomerNotFoundException;
import com.mami.luv2codes.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/customers")
  public Customer add(@RequestBody Customer theCustomer) {

    //also just in case the pass in id in Json .. set id to 0
    //this is force a save of new item - instead of update because Hibernate

    theCustomer.setId(0);

    customerService.saveCustomer(theCustomer);
    return theCustomer;
  }

  @PutMapping("/customers")
  public Customer update(@RequestBody Customer theCustomer){

    customerService.saveCustomer(theCustomer);

    return theCustomer;
  }

  @DeleteMapping("/customers/{id}")
  public String delete(@PathVariable("id") int id) {

    Customer temp = customerService.getCustomer(id);

    if(temp == null) {
      throw new CustomerNotFoundException("Customer id not found : " + id);
    }

    customerService.deleteCustomer(id);

    return "Deleted customer with id -" + id;

  }
}
