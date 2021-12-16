package com.mami.luv2codes.dao;

import com.mami.luv2codes.entity.Customer;
import java.util.List;



public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
