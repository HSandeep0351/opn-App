package com.opnapp.validators;


import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Customer;

public class CustomerValidator {

    private static final Logger logger = LoggerFactory.getLogger(CustomerValidator.class);

    public static void validateCustomer(Customer customer) {
        if (customer == null) {
            logger.error("Customer object is null");
            throw new InvalidEntityException("Customer object is null");
        }

        validateName(customer.getName());
        validateEmail(customer.getEmail());
        validateUsername(customer.getUsername());
        validatePassword(customer.getPassword());
    }

    private static void validateName(String name) {
        if (isEmpty(name) || !name.matches("^[a-zA-Z]+(?:\s[a-zA-Z]+){0,2}$")) {
            logger.info("Name validation failed: Name should contain only letters");
            throw new InvalidEntityException("Name should contain only letters");
        }
    }

    private static void validateEmail(String email) {
        if (isEmpty(email) || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            logger.info("Email validation failed: Provide a valid email for customer");
            throw new InvalidEntityException("Provide a valid email for customer");
        }
    }

    private static void validateUsername(String username) {
        if (isEmpty(username)) {
            logger.info("Username validation failed: Provide a valid username for customer");
            throw new InvalidEntityException("Provide a valid username for customer");
        }
        // You may include more specific username validations if needed
    }

    private static void validatePassword(String password) {
        if (isEmpty(password) || password.length() < 8 || !password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            logger.info("Password validation failed: Password should contain at least 8 characters, including at least one uppercase letter, one digit, and one special character");
            throw new InvalidEntityException("Password should contain at least 8 characters, including at least one uppercase letter, one digit, and one special character");
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
