package com.opnapp.DAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Address;
import com.opnapp.models.Customer;
import com.opnapp.repositories.CustomerRepository;
import com.opnapp.validators.CustomerValidator;



@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private final CustomerRepository customerRepository;
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
    @Autowired
    public CustomerDAOImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	@Override
	public Customer addCustomer(Customer customer, Address address) throws InvalidEntityException {
			CustomerValidator.validateCustomer(customer);
			
			address.setCustomer(customer);
			customer.setAddress(address);
			Customer savedCustomer = customerRepository.save(customer);
            logger.info("Customer added successfully: " + savedCustomer);
            return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws InvalidEntityException {
		
			CustomerValidator.validateCustomer(customer);
			Long customerId = customer.getId(); 

	        Customer existingCustomer = customerRepository.findActiveCustomerById(customerId);
	        if(existingCustomer==null) throw new InvalidEntityException("Customer with ID " + customerId + " not found");
	        
	        
	        existingCustomer.setName(customer.getName());
	        existingCustomer.setEmail(customer.getEmail());
	        existingCustomer.setUsername(customer.getUsername());
	        existingCustomer.setPassword(customer.getPassword());
	        logger.info("Updated Successfully");
	        existingCustomer.setAddress(customer.getAddress());
	        return customerRepository.save(existingCustomer); 
	}

	@Override
	public Customer deleteCustomer(Long customerId) throws InvalidEntityException {
			Customer deletedCustomer=customerRepository.findById(customerId).get();
            if(deletedCustomer.isDeleted()!=true) {
             	 logger.info("Deleting customer with ID: {}", customerId);
             	customerRepository.markAsDeleted(customerId);
             	  logger.info("Customer deleted successfully: " + customerId);
      	        }else {
      	        	throw new InvalidEntityException("customerId not found");
      	        }
            return deletedCustomer;
        
	}

	@Override
	public Customer viewCustomer(Long customerId) throws InvalidEntityException {
		
            Customer customer = customerRepository.findActiveCustomerById(customerId);
            if (customer == null) {
                logger.error("Customer with ID " + customerId + " does not exist");
                throw new InvalidEntityException("Customer does not exist");
            }
            logger.info("Viewed customer with ID: " + customerId);
            return customer;
        
	}

	@Override
	public List<Customer> viewAllCustomers() throws InvalidEntityException {
		
            List<Customer> customers = customerRepository.findByIsDeleted(false);
             logger.info("Viewed all active customers");
            return customers;
	}
	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

//	@Override
//	public Customer validateCustomer(String userName, String password) {
//		return customerRepository.findByUsernameAndPassword(userName, password);
//		// TODO Auto-generated method stub
//		
//	}

}
