package com.opnapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Administrator;
import com.opnapp.services.AdministratorService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/Administrator")
public class AdministratorController {
	private final AdministratorService administratorService;
	@Autowired
	public AdministratorController(AdministratorService administratorService){
		this.administratorService = administratorService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Administrator>> getAllAdministrator()throws InvalidEntityException{
		List<Administrator> allAdministrators = administratorService.getAllAdministrators();
		return ResponseEntity.ok(allAdministrators);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addAdministrator(@RequestBody Administrator administrator)throws InvalidEntityException{
		administratorService.addAdministrator(administrator);
		return ResponseEntity.ok("Administrator Added");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAdministrator(@RequestBody Administrator administrator)throws InvalidEntityException{
		administratorService.updateAdministrator(administrator);
		return ResponseEntity.ok("Aministrator "+administrator.getAdminId()+" is updated successfully");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAdministrator(@RequestBody Administrator administrator)throws InvalidEntityException{
		administratorService.deleteAdministrator(administrator);
		return ResponseEntity.ok("Aministrator "+administrator.getAdminId()+" is deleted successfully");
	}
	
	@GetMapping("/getById/{administratorId}")
	public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long administratorId)throws InvalidEntityException{
		Administrator administrator  = administratorService.getAdministratorById(administratorId);
		return ResponseEntity.ok(administrator);
	}
}
