package com.opnapp.DAO;

import java.util.List;
import com.opnapp.models.Seed;

public interface SeedDao {

	public Seed addSeed(Seed seed);

	public Seed updateSeed(Seed seed);

	public Seed deleteSeed(Long seedId);

	public Seed viewSeedById(Long seedId);

	public List<Seed> viewSeedByName(String commonName);

	public List<Seed> viewAllSeeds();

	public List<Seed> viewAllSeedByType(String typeOfSeed);
}
