package com.opnapp.services;

import java.util.List;
import com.opnapp.models.Seed;

public interface SeedService {
	public Seed addSeed(Seed seed);

	public Seed updateSeed(Seed seed);

	public Seed deleteSeed(Long seedId);

	public Seed viewSeedById(Long seedId);

	public List<Seed> viewSeedByName(String commonName);

	public List<Seed> viewAllSeeds();

	public List<Seed> viewAllSeedByType(String typeOfSeed);

}
