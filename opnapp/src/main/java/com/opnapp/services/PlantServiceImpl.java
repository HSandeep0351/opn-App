package com.opnapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opnapp.DAO.PlantDaoImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Plant;

@Service
public class PlantServiceImpl implements PlantService {

	private static final Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);

	@Autowired
	private PlantDaoImpl plantDaoImpl;

	@Override
	public Plant addPlant(Plant plant) throws InvalidEntityException {
		logger.info("Adding a new plant");
		return plantDaoImpl.addPlant(plant);
	}

	@Override
	public Plant updatePlant(Plant plant) throws InvalidEntityException {
		logger.info("Updating plant");
		return plantDaoImpl.updatePlant(plant);
	}

	@Override
	public Plant deletePlant(Long plantId) throws InvalidEntityException {
		logger.info("Deleting plant");
		return plantDaoImpl.deletePlant(plantId);
	}

	@Override
	public Plant viewPlantById(Long plantId) throws InvalidEntityException {
		logger.info("Viewing plant by ID");
		return plantDaoImpl.viewPlantById(plantId);
	}

	@Override
	public List<Plant> viewPlantByName(String commonName) throws InvalidEntityException {
		logger.info("Viewing plants by common name");
		return plantDaoImpl.viewPlantByName(commonName);
	}

	@Override
	public List<Plant> viewAllPlants() throws InvalidEntityException {
		logger.info("Viewing all plants");
		return plantDaoImpl.viewAllPlants();
	}

	@Override
	public List<Plant> viewAllPlantsByType(String typeOfPlant) throws InvalidEntityException {
		logger.info("Viewing all plants by type");
		return plantDaoImpl.viewAllPlantsByType(typeOfPlant);
	}
}
//Final One