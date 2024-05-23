package com.opnapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opnapp.DAO.SeedDaoImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Seed;

@Service
public class SeedServiceImpl implements SeedService {

private static final Logger logger = LoggerFactory.getLogger(SeedServiceImpl.class);

	private final SeedDaoImpl seedDaoimpl;

	@Autowired
	public SeedServiceImpl(SeedDaoImpl seedDaoimpl) {
		this.seedDaoimpl = seedDaoimpl;
	}

	@Override
	public Seed addSeed(Seed seed) throws InvalidEntityException {
		logger.info("Adding seed: {}", seed);
		Seed addedSeed = seedDaoimpl.addSeed(seed);
		logger.info("Seed added successfully: {}", addedSeed);
		return addedSeed;
	}

	@Override
	public Seed updateSeed(Seed seed) throws InvalidEntityException {
		logger.info("Updating seed: {}", seed);
		Seed updatedSeed = seedDaoimpl.updateSeed(seed);
		logger.info("Seed updated successfully: {}", updatedSeed);
		return updatedSeed;
	}

	@Override
	public Seed deleteSeed(Long seedId) throws InvalidEntityException {
		logger.info("Deleting seed: {}", seedId);
		return seedDaoimpl.deleteSeed(seedId);

	}

	@Override
	public Seed viewSeedById(Long seedId) throws InvalidEntityException {
		logger.info("Viewing seed by ID: {}", seedId);
		Seed result = seedDaoimpl.viewSeedById(seedId);
		logger.info("Seed found: {}", result);
		return result;
	}

	@Override
	public List<Seed> viewSeedByName(String commonName) throws InvalidEntityException {
		logger.info("Viewing seeds by common name: {}", commonName);
		List<Seed> result = seedDaoimpl.viewSeedByName(commonName);
		logger.info("Seeds found: {}", result);
		return result;
	}

	@Override
	public List<Seed> viewAllSeeds() throws InvalidEntityException {
		logger.info("Viewing all seeds");
		List<Seed> result = seedDaoimpl.viewAllSeeds();
		logger.info("All seeds found: {}", result);
		return result;
	}

	@Override
	public List<Seed> viewAllSeedByType(String typeOfSeed) throws InvalidEntityException {
		logger.info("Viewing seeds by type: {}", typeOfSeed);
		List<Seed> result = seedDaoimpl.viewAllSeedByType(typeOfSeed);
		logger.info("Seeds found by type {}: {}", typeOfSeed, result);
		return result;
	}
}
