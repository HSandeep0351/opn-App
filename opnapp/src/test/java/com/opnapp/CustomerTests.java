package com.opnapp;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.opnapp.DAO.CustomerDAO;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Address;
import com.opnapp.models.Customer;
import com.opnapp.services.CustomerServiceImpl;
 
 
public class CustomerTests {
 
    @Mock
    private CustomerDAO customerDAO;
 
    @Mock
    private Logger logger;
 
    @InjectMocks
    private CustomerServiceImpl customerService;
 
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testAddCustomer() throws InvalidEntityException {
        Customer customerToAdd = new Customer();
        Address addressToAdd = new Address();
        when(customerDAO.addCustomer(customerToAdd, addressToAdd)).thenReturn(customerToAdd);
 
        Customer result = customerService.addCustomer(customerToAdd,addressToAdd);
 
        assertEquals(customerToAdd, result);
        verify(customerDAO, times(1)).addCustomer(customerToAdd,addressToAdd);
    }
 
    @Test
    public void testUpdateCustomer() throws InvalidEntityException {
        Customer customerToUpdate = new Customer(/* Provide necessary parameters */);
        when(customerDAO.updateCustomer(customerToUpdate)).thenReturn(customerToUpdate);
 
        Customer result = customerService.updateCustomer(customerToUpdate);
 
        assertEquals(customerToUpdate, result);
        verify(customerDAO, times(1)).updateCustomer(customerToUpdate);
    }
 
    @Test
    public void testDeleteCustomer_WithInvalidEntityException() throws InvalidEntityException {
        Long customerId = 1L; 
        Customer customerToDelete = new Customer();
        doThrow(InvalidEntityException.class).when(customerDAO).deleteCustomer(customerId);
        Assertions.assertThrows(InvalidEntityException.class, () -> customerService.deleteCustomer(customerId));
        verify(customerDAO, times(1)).deleteCustomer(customerId);
    }

    @Test
    public void testViewCustomer() throws InvalidEntityException {
        Long customerId = 1L;
        Customer expectedCustomer = new Customer(/* Provide necessary parameters */);
        when(customerDAO.viewCustomer(customerId)).thenReturn(expectedCustomer);
 
        Customer result = customerService.viewCustomer(customerId);
 
        assertEquals(expectedCustomer, result);
        verify(customerDAO, times(1)).viewCustomer(customerId);
    }
 
    @Test
    public void testViewAllCustomers() throws InvalidEntityException {
        List<Customer> mockCustomers = new ArrayList<>(); // Add mock customers
        when(customerDAO.viewAllCustomers()).thenReturn(mockCustomers);
 
        List<Customer> result = customerService.viewAllCustomers();
 
        assertEquals(mockCustomers, result);
        verify(customerDAO, times(1)).viewAllCustomers();
    }
 
    @Test
    public void testAddCustomer_WithInvalidEntityException() throws InvalidEntityException {
        Customer customerToAdd = new Customer();
        Address addressToAdd = new Address();
        doThrow(InvalidEntityException.class).when(customerDAO).addCustomer(customerToAdd,addressToAdd);
 
        Assertions.assertThrows(InvalidEntityException.class, () -> customerService.addCustomer(customerToAdd,addressToAdd));
 
        verify(customerDAO, times(1)).addCustomer(customerToAdd,addressToAdd);
    }
 
    @Test
    public void testUpdateCustomer_WithInvalidEntityException() throws InvalidEntityException {
        Customer customerToUpdate = new Customer();
        doThrow(InvalidEntityException.class).when(customerDAO).updateCustomer(customerToUpdate);
 
        Assertions.assertThrows(InvalidEntityException.class, () -> customerService.updateCustomer(customerToUpdate));
 
        verify(customerDAO, times(1)).updateCustomer(customerToUpdate);
    }
 
    @Test
    public void testViewCustomer_WithInvalidEntityException() throws InvalidEntityException {
        Long customerId = 1L;
        doThrow(InvalidEntityException.class).when(customerDAO).viewCustomer(customerId);
 
        Assertions.assertThrows(InvalidEntityException.class, () -> customerService.viewCustomer(customerId));
 
        verify(customerDAO, times(1)).viewCustomer(customerId);
    }
 
    @Test
    public void testViewAllCustomers_WithInvalidEntityException() throws InvalidEntityException {
        doThrow(InvalidEntityException.class).when(customerDAO).viewAllCustomers();
 
        Assertions.assertThrows(InvalidEntityException.class, () -> customerService.viewAllCustomers());
 
        verify(customerDAO, times(1)).viewAllCustomers();
    }
}