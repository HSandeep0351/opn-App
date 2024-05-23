package com.opnapp;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.opnapp.DAO.SeedDaoImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Seed;
import com.opnapp.services.SeedServiceImpl;

public class SeedApplicationTests {

	@Mock
	private SeedDaoImpl seedDao;

	@InjectMocks
	private SeedServiceImpl seedService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddSeed() throws InvalidEntityException {

		Seed seedToAdd = new Seed();
		Seed addedSeed = new Seed();
		when(seedDao.addSeed(seedToAdd)).thenReturn(addedSeed);

		Seed result = seedService.addSeed(seedToAdd);

		Assertions.assertEquals(addedSeed, result);
		verify(seedDao, times(1)).addSeed(seedToAdd);
	}

	@Test
	public void testUpdateSeed() throws InvalidEntityException {

		Seed seedToUpdate = new Seed();
		Seed updatedSeed = new Seed();
		when(seedDao.updateSeed(seedToUpdate)).thenReturn(updatedSeed);

		Seed result = seedService.updateSeed(seedToUpdate);

		Assertions.assertEquals(updatedSeed, result);
		verify(seedDao, times(1)).updateSeed(seedToUpdate);
	}

	@Test
	public void testDeleteSeed() throws InvalidEntityException {

		Seed seedToDelete = new Seed();

		seedService.deleteSeed(seedToDelete.getSeedId());

		verify(seedDao, times(1)).deleteSeed(seedToDelete.getSeedId());
	}

	@Test
	public void testViewSeedById() throws InvalidEntityException {

		Long seedId = 1L;
		Seed seed = new Seed();
		when(seedDao.viewSeedById(seedId)).thenReturn(seed);

		Seed result = seedService.viewSeedById(seedId);

		Assertions.assertEquals(seed, result);
		verify(seedDao, times(1)).viewSeedById(seedId);
	}

	@Test
	public void testViewSeedByName() throws InvalidEntityException {

		String commonName = "TestSeed";
		List<Seed> seeds = new ArrayList<>();
		seeds.add(new Seed());
		when(seedDao.viewSeedByName(commonName)).thenReturn(seeds);

		List<Seed> result = seedService.viewSeedByName(commonName);

		Assertions.assertEquals(seeds, result);
		verify(seedDao, times(1)).viewSeedByName(commonName);
	}

	@Test
	public void testViewAllSeeds() throws InvalidEntityException {

		List<Seed> allSeeds = new ArrayList<>();
		allSeeds.add(new Seed());
		when(seedDao.viewAllSeeds()).thenReturn(allSeeds);

		List<Seed> result = seedService.viewAllSeeds();

		Assertions.assertEquals(allSeeds, result);
		verify(seedDao, times(1)).viewAllSeeds();
	}

	@Test
	public void testViewAllSeedByType() throws InvalidEntityException {

		String typeOfSeed = "TestType";
		List<Seed> seedsByType = new ArrayList<>();
		seedsByType.add(new Seed());
		when(seedDao.viewAllSeedByType(typeOfSeed)).thenReturn(seedsByType);

		List<Seed> result = seedService.viewAllSeedByType(typeOfSeed);

		Assertions.assertEquals(seedsByType, result);
		verify(seedDao, times(1)).viewAllSeedByType(typeOfSeed);
	}
}
