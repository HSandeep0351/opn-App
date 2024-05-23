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
import com.opnapp.models.Plant;
import com.opnapp.services.PlantService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/plant")
public class PlantController {
	
	@Autowired
	private PlantService plantService;
	@PostMapping("/addPlant")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant)throws InvalidEntityException {
		 Plant addedPlant= plantService.addPlant(plant);
		 return ResponseEntity.ok(addedPlant);
	}
	@PutMapping("/updatePlant")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant)throws InvalidEntityException { 
		Plant updatedPlant = plantService.updatePlant(plant);
		return ResponseEntity.ok(updatedPlant);
	}
	
	@DeleteMapping("/deletePlant/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Long plantId)throws InvalidEntityException {
 
		Plant updatedPlant=plantService.deletePlant(plantId);
		return ResponseEntity.ok(updatedPlant );
	}
	@GetMapping("/viewPlantById/{plantId}")
	public ResponseEntity<Plant> viewPlantById( @PathVariable Long plantId) throws InvalidEntityException{
		Plant viewPlantById= plantService.viewPlantById(plantId);
		return ResponseEntity.ok(viewPlantById);
		}
	@GetMapping("/viewPlantByName/{commonName}")
	public ResponseEntity<List<Plant>> viewPlantByName(@PathVariable String commonName)throws InvalidEntityException{
		List<Plant> viewPlantByName = plantService.viewPlantByName(commonName);
		return ResponseEntity.ok(viewPlantByName);
	}
	@GetMapping("/viewAllPlants")
	public ResponseEntity<List<Plant>> viewAllPlants()throws InvalidEntityException{
		List<Plant> viewAllPlants = plantService.viewAllPlants();
		return ResponseEntity.ok(viewAllPlants);
	}
	@GetMapping("/viewAllPlantsByType/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlantsByType(@PathVariable String typeOfPlant)throws InvalidEntityException{
		List<Plant> viewAllPlantsByType = plantService.viewAllPlantsByType(typeOfPlant);
		return ResponseEntity.ok(viewAllPlantsByType);
	
	}
}
//Final one