package com.opnapp.DAO;

import java.util.List; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Plant;
import com.opnapp.models.Planter;
import com.opnapp.repositories.PlantRepo;
import com.opnapp.repositories.PlanterRepository;
import com.opnapp.validators.Plantvalidator;



@Repository
public class PlantDaoImpl implements PlantDao {

	private static final Logger logger = LoggerFactory.getLogger(PlantDaoImpl.class);

	@Autowired
	private PlantRepo plantRepo;
	@Autowired
	private PlanterRepository planterRepository;

	@Override
	public Plant addPlant(Plant plant) throws InvalidEntityException {
		Plantvalidator.validatePlant(plant);
		logger.info("Adding plant: {}", plant);
		Planter planter=planterRepository.findById(plant.getPlanter().getPlanterId()).get();
		if(planter==null) {
			planterRepository.save(plant.getPlanter());
		}else {
			plant.setPlanter(planter);
		}
		Plant addedPlant=plantRepo.save(plant);
		logger.info("Plant added successfully: {}", addedPlant);
		return addedPlant;
	}

	@Override
	public Plant updatePlant(Plant plant) throws InvalidEntityException {
		Plantvalidator.validatePlant(plant);
		Plant existingPlant = plantRepo.findById(plant.getPlantId()).orElse(null);

		if (existingPlant == null) {
			logger.info("Plant with ID {} doesn't exist", plant.getPlantId());
			throw new InvalidEntityException("Plant " + plant.getPlantId() + " doesn't exist");
		} else {
			logger.info("Updating plant with ID: {}", plant.getPlantId());
			existingPlant.setPlantHeight(plant.getPlantHeight());
			existingPlant.setBloomTime(plant.getBloomTime());
			existingPlant.setTypeOfPlant(plant.getTypeOfPlant());
			existingPlant.setCommonName(plant.getCommonName());
			existingPlant.setExposure(plant.getExposure());
			existingPlant.setFlowerColor(plant.getFlowerColor());
			existingPlant.setTemperature(plant.getTemperature());
			existingPlant.setDescription(plant.getDescription());
			existingPlant.setPlantsStock(plant.getPlantsStock());
			existingPlant.setPlantCost(plant.getPlantCost());
			Plant updatedPlant = plantRepo.save(existingPlant);
			logger.info("Plant updated successfully");
			return updatedPlant;
		}
	}

	@Override
	public Plant deletePlant(Long plantId) throws InvalidEntityException {
		Plantvalidator.validatePlantById(plantId);
		Plant deletedPlant=plantRepo.findById(plantId).get();
		if(deletedPlant.getIsDeleted()!=true) {
       	 logger.info("Deleting seed with ID: {}", plantId);
         	plantRepo.markAsDeleted(plantId);
	        logger.info("Seed deleted successfully with ID: {}",plantId);
	        }else {
	        	throw new InvalidEntityException("plantId not found");
	        }
		return deletedPlant;
	}

	@Override
	public Plant viewPlantById(Long plantId) throws InvalidEntityException {
		Plantvalidator.validatePlantById(plantId);
		 Plant viewedPlant= plantRepo.findPlantById(plantId);
		 if(viewedPlant==null) {
			 throw new InvalidEntityException("Enter valid Id");
		 }
		logger.info("Viewing plant with ID: {}", plantId);
		return plantRepo.findPlantById(plantId);
	}

	@Override
	public List<Plant> viewPlantByName(String commonName) throws InvalidEntityException {
		Plantvalidator.validatePlantByName(commonName);
		 List<Plant> viewedPlant= plantRepo.findBycommonName(commonName);
		 if(viewedPlant.isEmpty()) {
			 throw new InvalidEntityException("Enter valid Common Name");
		 }
		logger.info("Viewing plants by common name: {}", commonName);
		return plantRepo.findBycommonName(commonName);
	}

	@Override
	public List<Plant> viewAllPlants() throws InvalidEntityException {
		logger.info("Viewing all plants");
		
		return plantRepo.findByIsDeleted(false);
	}

	@Override
	public List<Plant> viewAllPlantsByType(String typeOfPlant) throws InvalidEntityException {
		Plantvalidator.validatePlantByType(typeOfPlant);
		 List<Plant> viewedPlant= plantRepo.findAllByTypeOfPlant(typeOfPlant);
		 if(viewedPlant==null) {
			 throw new InvalidEntityException("Enter valid Type Of Plant");
		 }
		logger.info("Viewing all plants by type: {}", typeOfPlant);
		return plantRepo.findAllByTypeOfPlant(typeOfPlant);
	}
}
// Final One 