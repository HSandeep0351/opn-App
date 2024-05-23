package com.opnapp.DAO;

import java.util.List;
import com.opnapp.models.Plant; 


public interface PlantDao {

	public Plant addPlant(Plant plant);

	public Plant updatePlant(Plant plant);

	public Plant deletePlant(Long plantId);

	public Plant viewPlantById(Long plantid);

	public List<Plant> viewPlantByName(String commonName);

	public List<Plant> viewAllPlants();

	public List<Plant> viewAllPlantsByType(String typeOfPlant);

}
//Final One