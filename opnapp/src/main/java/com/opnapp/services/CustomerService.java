package com.opnapp.services;

import java.util.List;

import com.opnapp.models.Address;
import com.opnapp.models.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer, Address address);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Long customerId);

	public Customer viewCustomer(Long customerId);

	public List<Customer> viewAllCustomers();
	// public Customer validateCustomer(String userName, String password);

}
