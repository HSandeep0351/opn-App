package com.opnapp.validators;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Plant;

public class Plantvalidator {

	public static void validatePlant(Plant plant) throws InvalidEntityException {
		if (plant == null) {
			throw new InvalidEntityException("Plant object is null");
		}
		

		if (plant.getPlantHeight() == null || plant.getPlantHeight() < 1) {
			throw new InvalidEntityException("Plant height should be a positive integer");
		}

		if (!isValidString(plant.getTypeOfPlant())) {
			throw new InvalidEntityException("Type of plant should not be blank");
		}

		if (!isValidString(plant.getCommonName())) {
			throw new InvalidEntityException("Common name should not be blank");
		}

		if (!isValidString(plant.getExposure())) {
			throw new InvalidEntityException("Exposure should not be blank");
		}

		if (!isValidString(plant.getFlowerColor())) {
			throw new InvalidEntityException("Flower color should not be blank");
		}

		if (!isValidString(plant.getTemperature())) {
			throw new InvalidEntityException("Temperature should not be blank");
		}

		if (plant.getPlantsStock() == null || plant.getPlantsStock() < 1) {
			throw new InvalidEntityException("Plant stock should be a positive integer");
		}
		if(plant.getPlantCost() == null || plant.getPlantCost() < 1) {
			throw new InvalidEntityException("Plant cost should be a positive number");
		}

		
		}
//	public static void validatePlantById(Long plantId) throws InvalidEntityException {
//
//		if (!isValidLongById(plantId)) {
//			throw new InvalidEntityException("Enter valid plant Id");
//		}
//	}
//
//	private static boolean isValidLongById(Long plantId) {
//	
//		return plantId != null && plantId >= 0;
//	}
	

	private static boolean isValidString(String value) {
		return value != null ;
	}


	public static void validatePlantById(Long plantId) {
		// TODO Auto-generated method stub
		if(!isValidById(plantId)) {
			throw new InvalidEntityException("PlantId Invalid");
		}
	}


	private static boolean isValidById(Long plantId) {
		// TODO Auto-generated method stub
		return plantId>=0;
	}


	public static void validatePlantByName(String commonName) {
		if(!isValidStringByName(commonName)) {
			throw new InvalidEntityException("Type of plant name should not be blank");
		}
	}


	private static boolean isValidStringByName(String commonName) {
		// TODO Auto-generated method stub
		return commonName != null && !commonName.isBlank();
	}


	public static void validatePlantByType(String typeOfPlant) {
		// TODO Auto-generated method stub
		if (!isValidStringByType(typeOfPlant)) {
			throw new InvalidEntityException("Type of plant should not be blank");
		}
		
	}


	private static boolean isValidStringByType(String typeOfPlant) {
		// TODO Auto-generated method stub
		return typeOfPlant != null && !typeOfPlant.isBlank();
	
}}
//Final One