package com.opnapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opnapp.DAO.AdministratorDAO;
import com.opnapp.models.Administrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorServiceImpl.class);
	private final AdministratorDAO administratorDao;
	
	@Autowired
	public AdministratorServiceImpl(AdministratorDAO administratorDao){
		this.administratorDao = administratorDao;
	}
	
	@Override
	public List<Administrator> getAllAdministrators() {
		LOGGER.info("Fetching all Administrators");
		return administratorDao.getAllAdministrators();
	}
	
	@Override
	public void addAdministrator(Administrator administrator) {
		LOGGER.info("Adding new Administrator");
		administratorDao.addAdministrator(administrator);	
	}

	@Override
	public void updateAdministrator(Administrator administrator) {
		LOGGER.info("Updating Administrator");
		administratorDao.updateAdministrator(administrator);
	}

	@Override
	public void deleteAdministrator(Administrator administrator) {
		LOGGER.info("Deleting Administrator");
		administratorDao.deleteAdministrator(administrator);
	}

	@Override
	public Administrator getAdministratorById(Long administratorId) {
		LOGGER.info("Fetching Administrator by Id");
		return administratorDao.getAdministratorById(administratorId);
	}
}
