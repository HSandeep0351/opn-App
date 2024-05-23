package com.opnapp.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Administrator;



public class AdministratorValidator {
    private static final Logger log = LoggerFactory.getLogger(AdministratorValidator.class);

    public static Boolean validateAdministrator(Administrator administrator) {
        if (administrator == null) {
            log.info("Administrator object is null.");
            throw new InvalidEntityException("Administrator object is null.");
        }

        if (!isValidAdminUserId(administrator.getAdminUserId())) {
            log.info("Invalid adminUserId: {}", administrator.getAdminUserId());
            throw new InvalidEntityException("Invalid adminUserId");
        }

        if (!isValidAdminPassword(administrator.getAdminPassword())) {
            log.info("Invalid adminPassword: {}", administrator.getAdminPassword());
            throw new InvalidEntityException("Invalid adminPassword");
        }

        return true;
    }

    private static boolean isValidAdminUserId(String adminUserId) {
        if (adminUserId == null || adminUserId.isEmpty()) {
            return false;
        }
        return adminUserId.matches("[a-zA-Z0-9]+");
    }

    private static boolean isValidAdminPassword(String adminPassword) {
        if (adminPassword == null || adminPassword.length() < 8) {
            return false;
        }
        return adminPassword.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$");
    }
}
