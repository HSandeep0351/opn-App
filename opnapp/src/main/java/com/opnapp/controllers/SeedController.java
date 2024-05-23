package com.opnapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.opnapp.models.Seed;
import com.opnapp.services.SeedService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/seed")
public class SeedController {

	@Autowired
	private SeedService seedService;

	@PostMapping("/addSeed")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed)throws InvalidEntityException {
		Seed addedSeed = seedService.addSeed(seed);
		return ResponseEntity.ok(addedSeed);
	}

	@PutMapping("/updateSeed")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) throws InvalidEntityException{
		Seed updatedSeed = seedService.updateSeed(seed);
		return new ResponseEntity<Seed>(updatedSeed, HttpStatus.OK);

	}

	@DeleteMapping("/deleteSeed/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Long seedId) throws InvalidEntityException {
		Seed deletedSeed = seedService.deleteSeed(seedId);
		return ResponseEntity.ok(deletedSeed);
	}

	@GetMapping("/viewSeedById/{seedId}")
	public ResponseEntity<Seed> viewSeedById(@PathVariable Long seedId) throws InvalidEntityException{
		Seed viewSeed = seedService.viewSeedById(seedId);
		return ResponseEntity.ok(viewSeed);

	}

	@GetMapping("/viewSeedByName/{commonName}")
	public ResponseEntity<List<Seed>> viewSeedByName(@PathVariable String commonName) throws InvalidEntityException{
		List<Seed> viewSeedByName = seedService.viewSeedByName(commonName);
		return ResponseEntity.ok(viewSeedByName);

	}

	@GetMapping("/viewAllSeeds")
	public ResponseEntity<List<Seed>> viewAllSeeds() throws InvalidEntityException{
		List<Seed> viewAllSeeds = seedService.viewAllSeeds();
		return ResponseEntity.ok(viewAllSeeds);
	}

	@GetMapping("/viewAllSeedByType/{typeOfSeed}")
	public ResponseEntity<List<Seed>> viewAllSeedByType(@PathVariable String typeOfSeed)throws InvalidEntityException {
		List<Seed> viewAllSeedByType = seedService.viewAllSeedByType(typeOfSeed);
		return ResponseEntity.ok(viewAllSeedByType);

	}
}