package com.opnapp.DAO;

import java.util.List;

import com.opnapp.models.Administrator;

public interface AdministratorDAO {
	
	public List<Administrator> getAllAdministrators();
	public void addAdministrator(Administrator administrator);
	public void updateAdministrator(Administrator administrator); 
	public void deleteAdministrator(Administrator administrator);
	public Administrator getAdministratorById(Long administratorId);
	public Administrator getAdministratorByUsername(String username);
}
