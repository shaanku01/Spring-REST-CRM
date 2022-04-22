package com.zemoso.springdemo.service;

import java.util.List;

import com.zemoso.springdemo.entity.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
