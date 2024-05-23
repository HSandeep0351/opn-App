package com.opnapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opnapp.DAO.CustomerDAO;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Address;
import com.opnapp.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer addCustomer(Customer customer, Address address) throws InvalidEntityException {

		logger.info("Adding customer...");
		return customerDAO.addCustomer(customer, address);

	}

	@Override
	public Customer updateCustomer(Customer customer) throws InvalidEntityException {

		logger.info("Updating customer...");
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public Customer deleteCustomer(Long customerId) throws InvalidEntityException {
		logger.info("Deleting customer...");
		return customerDAO.deleteCustomer(customerId);

	}

	@Override
	public Customer viewCustomer(Long customerId) throws InvalidEntityException {
		logger.info("Viewing customer by ID: " + customerId);
		return customerDAO.viewCustomer(customerId);
	}

	@Override
	public List<Customer> viewAllCustomers() throws InvalidEntityException {

		logger.info("Viewing all customers...");
		return customerDAO.viewAllCustomers();

	}

//	@Override
//	public Customer validateCustomer(String userName, String password) {
//		// TODO Auto-generated method stub
//		return customerDAO.validateCustomer(userName, password);
//	}

}
