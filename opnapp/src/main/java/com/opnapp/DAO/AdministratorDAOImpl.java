package com.opnapp.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Administrator;
import com.opnapp.models.Customer;
import com.opnapp.repositories.AdministratorRepository;
import com.opnapp.validators.AdministratorValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AdministratorDAOImpl implements AdministratorDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorDAOImpl.class);
	private final AdministratorRepository administratorRepository;
	
	@Autowired
	AdministratorDAOImpl(AdministratorRepository administratorRepository){
		this.administratorRepository=administratorRepository;
	}
	public List<Administrator> getAllAdministrators() {
		List<Administrator> adminList=administratorRepository.findByIsDeleted(false);
		LOGGER.info("All administrators fetched !");
		return adminList;
	}
	@Override
	public void addAdministrator(Administrator administrator) {
		AdministratorValidator.validateAdministrator(administrator);
		administratorRepository.save(administrator);
		LOGGER.info("New administrator added !");
	}
	@Override
	public void updateAdministrator(Administrator administrator) {
		AdministratorValidator.validateAdministrator(administrator);
		administratorRepository.updateAdministrator(administrator.getAdminId(),administrator.getAdminUserId(),administrator.getAdminPassword());
		LOGGER.info("Administrator updated !");
	}
	@Override
	public void deleteAdministrator(Administrator administrator) {
		AdministratorValidator.validateAdministrator(administrator);
		Administrator deletedAdmin=administratorRepository.findById(administrator.getAdminId()).get();
		 if(deletedAdmin.getIsDeleted()!=true) {
			 LOGGER.info("Deleting Admin with ID: {}", administrator.getAdminId());
			 administratorRepository.markAsDeleted(administrator.getAdminId());
         	LOGGER.info("Administrator with ID : "+administrator.getAdminId()+" deleted !");
  	        }else {
  	        	throw new InvalidEntityException("customerId not found");
  	        }
	}
	
	@Override
	public Administrator getAdministratorById(Long administratorId) {
		Administrator administrator = administratorRepository.findById(administratorId).get();
		if(administrator == null) {
			LOGGER.info("Administrator with ID : "+administratorId+" not found !");
			throw new InvalidEntityException("Administrator not found");
		}
		LOGGER.info("Administrator with ID : "+administratorId+" fetched !");
		return administrator;
	}
	
	public Administrator getAdministratorByUsername(String username) {
		System.out.println("abeeee");
		Administrator administrator = administratorRepository.findByAdminUserId(username);
		return administrator;
	}
}
