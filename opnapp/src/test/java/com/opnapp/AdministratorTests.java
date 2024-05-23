package com.opnapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.opnapp.controllers.AdministratorController;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Administrator;
import com.opnapp.services.AdministratorService;

@SpringBootTest
class AdministratorTests {
	 @Mock
	    private AdministratorService administratorService;

	    @InjectMocks
	    private AdministratorController administratorController;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testGetAllAdministrator() throws InvalidEntityException {
	        List<Administrator> administrators = new ArrayList<>();
	        administrators.add(new Administrator());
	        
	        when(administratorService.getAllAdministrators()).thenReturn(administrators);

	        ResponseEntity<List<Administrator>> result = administratorController.getAllAdministrator();

	        doThrow(new InvalidEntityException("Invalid Administrator")).when(administratorService)
	                .getAllAdministrators();

	        if (result.getBody().size() == 0) {
	        	assertNotNull(result);
	        	assertEquals(0,result.getBody().size());
	        } else {
	            assertNotNull(result);
	            assertEquals(200, result.getStatusCode());
	            assertEquals(1, result.getBody().size());
	        }
	    }


	    @Test
	    public void testAddAdministrator() throws InvalidEntityException {
	        Administrator administrator = new Administrator();
	        doNothing().when(administratorService).addAdministrator(administrator);

	        ResponseEntity<String> result = administratorController.addAdministrator(administrator);

	        assertNotNull(result);
	        assertEquals(200, result.getStatusCode());
	        assertEquals("Administrator Added", result.getBody());
	    }

	    @Test
	    public void testUpdateAdministrator() throws InvalidEntityException {
	        Administrator administrator = new Administrator();
	        doNothing().when(administratorService).updateAdministrator(administrator);

	        ResponseEntity<String> result = administratorController.updateAdministrator(administrator);

	        assertNotNull(result);
	        assertEquals(200, result.getStatusCode());
	        assertEquals("Aministrator " + administrator.getAdminId() + " is updated successfully", result.getBody());
	    }

	    @Test
	    public void testDeleteAdministrator() throws InvalidEntityException {
	        Administrator administrator = new Administrator();
	        doNothing().when(administratorService).deleteAdministrator(administrator);

	        ResponseEntity<String> result = administratorController.deleteAdministrator(administrator);

	        assertNotNull(result);
	        assertEquals(200, result.getStatusCode());
	        assertEquals("Aministrator " + administrator.getAdminId() + " is deleted successfully", result.getBody());
	    }

	    @Test
	    public void testGetAdministratorById() throws InvalidEntityException {
	        Long administratorId = 1L;
	        Administrator administrator = new Administrator();
	        administrator.setAdminId(administratorId);

	        when(administratorService.getAdministratorById(administratorId)).thenReturn(administrator);

	        ResponseEntity<Administrator> result = administratorController.getAdministratorById(administratorId);

	        doThrow(new InvalidEntityException("Invalid Administrator")).when(administratorService)
	                .getAdministratorById(administratorId);

	        if (result.getBody() == null) {
	            assertNull(result.getBody());
	        } else {
	            assertNotNull(result);
	            assertEquals(200, result.getStatusCode());
	            assertEquals(administratorId, result.getBody().getAdminId());
	        }
	    }

}
