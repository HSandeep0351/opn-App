package com.opnapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Customer;
import com.opnapp.services.CustomerService;
import com.opnapp.utilities.CustomerAddressGroup;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerAddressGroup custAddGrp)throws InvalidEntityException {
    	
    	Customer addedCustomer =customerService.addCustomer(custAddGrp.getCustomer(),custAddGrp.getAddress());
        return ResponseEntity.ok(addedCustomer);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws InvalidEntityException {
    	
    	Customer updatedCustomer = customerService.updateCustomer(customer);
    	
    		return ResponseEntity.ok(updatedCustomer);
    	
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId) throws InvalidEntityException {
    	Customer deletedCustomer=customerService.deleteCustomer(customerId);
        return ResponseEntity.ok(deletedCustomer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable Long customerId)throws InvalidEntityException {
    	Customer viewwCustomer = customerService.viewCustomer(customerId);
        return ResponseEntity.ok(viewwCustomer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> viewAllCustomers() throws InvalidEntityException {
    	List<Customer> customers = customerService.viewAllCustomers();
        return ResponseEntity.ok(customers);
    }

    
}
