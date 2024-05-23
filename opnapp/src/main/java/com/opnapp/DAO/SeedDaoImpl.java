package com.opnapp.DAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;
import com.opnapp.models.Seed;
import com.opnapp.repositories.PlanterRepository;
import com.opnapp.repositories.SeedRepository;
import com.opnapp.validators.SeedValidator;

@Repository
public class SeedDaoImpl implements SeedDao {

	private static final Logger logger = LoggerFactory.getLogger(SeedDaoImpl.class);

	private final SeedRepository seedRepository;

	@Autowired
	public SeedDaoImpl(SeedRepository seedRepository) {
		this.seedRepository = seedRepository;
	}
	@Autowired
	PlanterRepository planterRepository;

	@Override
	public Seed addSeed(Seed seed) throws InvalidEntityException {
		SeedValidator.validateSeed(seed);
		logger.info("Adding seed: {}", seed);
		Planter planter =planterRepository.findById(seed.getPlanter().getPlanterId()).get();
		if(planter==null) {
			planterRepository.save(seed.getPlanter());	
		}else {
			seed.setPlanter(planter);
		}
		Seed addedSeed=seedRepository.save(seed);
		logger.info("Seed added successfully: {}", addedSeed);
		return addedSeed;
	}

	@Override
	public Seed updateSeed(Seed seed) throws InvalidEntityException {
		SeedValidator.validateSeed(seed);
		logger.info("Updating seed: {}", seed);

		Seed existingSeed = seedRepository.findById(seed.getSeedId()).orElse(null);

		if (existingSeed == null) {
			throw new InvalidEntityException("Seed " + seed.getSeedId() + " does not exist");
		} else {
			existingSeed.setCommonName(seed.getCommonName());
			existingSeed.setBloomTime(seed.getBloomTime());
			existingSeed.setWatering(seed.getWatering());
			existingSeed.setDifficultyLevel(seed.getDifficultyLevel());
			existingSeed.setTemperature(seed.getTemperature());
			existingSeed.setTypeOfSeed(seed.getTypeOfSeed());
			existingSeed.setDescription(seed.getDescription());
			existingSeed.setStock(seed.getStock());
			existingSeed.setCost(seed.getCost());
			existingSeed.setSeedsPerPacket(seed.getSeedsPerPacket());

			logger.info("Seed {} updated successfully", seed.getSeedId());
			return seedRepository.save(existingSeed);
		}
	}

	@Override
    public Seed deleteSeed(Long seedId) throws InvalidEntityException {
		Seed deletedSeed = seedRepository.findById(seedId).get();
        //SeedValidator.validateSeedrById(seedId);
        if(deletedSeed.getIsDeleted()!=true) {
        	 logger.info("Deleting seed with ID: {}", seedId);
	        seedRepository.markAsDeleted(seedId);
	        logger.info("Seed deleted successfully with ID: {}",seedId);
	        }else {
	        	throw new InvalidEntityException("SeedId not found");
	        }
        return deletedSeed;
    }

	@Override
	public Seed viewSeedById(Long seedId) throws InvalidEntityException {
		logger.info("Viewing seed by ID: {}", seedId);
		Seed result = seedRepository.findSeedById(seedId);
		logger.info("Seed found: {}", result);
 
		if (result == null) {
			throw new InvalidEntityException("Seed with ID " + seedId + " not found");
		}
 
		return result;
	}
 
	@Override
	public List<Seed> viewSeedByName(String commonName) throws InvalidEntityException {
		SeedValidator.validateName(commonName);
		logger.info("Viewing seeds by common name: {}", commonName);
		List<Seed> result = seedRepository.findByCommonName(commonName);
		if(result.isEmpty()) {
			throw new InvalidEntityException("commonName not found");
		}
	
		logger.info("Seeds found: {}", result);
		return result;
	}
 
	@Override
	public List<Seed> viewAllSeeds() throws InvalidEntityException {
		logger.info("Viewing all seeds");
		List<Seed> result = seedRepository.findByIsDeleted(false);
		logger.info("All seeds found: {}", result);
		return result;
	}
 
	@Override
	public List<Seed> viewAllSeedByType(String typeOfSeed) throws InvalidEntityException {
		SeedValidator.validatetypeOfSeed(typeOfSeed);
		logger.info("Viewing seeds by type: {}", typeOfSeed);
		List<Seed> result = seedRepository.findAllByTypeOfSeed(typeOfSeed);
		if(result.isEmpty()) {
			throw new InvalidEntityException("Type Of SEED not found");
		}
		
		logger.info("Seeds found by type {}: {}", typeOfSeed, result);
		
		return result;
	}
}