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

import com.opnapp.DAO.PlantDaoImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Plant;
import com.opnapp.services.PlantServiceImpl;

public class PlantTests {

	@Mock
	private PlantDaoImpl plantDao;

	@InjectMocks
	private PlantServiceImpl plantService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddPlant() throws InvalidEntityException {
		Plant plantToAdd = new Plant();
		when(plantDao.addPlant(plantToAdd)).thenReturn(plantToAdd);

		Plant result = plantService.addPlant(plantToAdd);

		Assertions.assertEquals(plantToAdd, result);
		verify(plantDao, times(1)).addPlant(plantToAdd);
	}

	@Test
	public void testUpdatePlant() throws InvalidEntityException {
		Plant plantToUpdate = new Plant();
		when(plantDao.updatePlant(plantToUpdate)).thenReturn(plantToUpdate);

		Plant result = plantService.updatePlant(plantToUpdate);

		Assertions.assertEquals(plantToUpdate, result);
		verify(plantDao, times(1)).updatePlant(plantToUpdate);
	}

	@Test
	public void testDeletePlant() throws InvalidEntityException {
		Plant plantToDelete = new Plant();

		plantService.deletePlant(plantToDelete.getPlantId());

		verify(plantDao, times(1)).deletePlant(plantToDelete.getPlantId());
	}

	@Test
	public void testViewPlantById() throws InvalidEntityException {
		Long plantId = 1L;
		Plant plant = new Plant(/* initialize plant object */);
		when(plantDao.viewPlantById(plantId)).thenReturn(plant);

		Plant result = plantService.viewPlantById(plantId);

		Assertions.assertEquals(plant, result);
		verify(plantDao, times(1)).viewPlantById(plantId);
	}

	@Test
	public void testViewPlantByName() throws InvalidEntityException {
		String commonName = "TestPlant";
		List<Plant> plants = new ArrayList<>();
		plants.add(new Plant());
		when(plantDao.viewPlantByName(commonName)).thenReturn(plants);

		List<Plant> result = plantService.viewPlantByName(commonName);

		Assertions.assertEquals(plants, result);
		verify(plantDao, times(1)).viewPlantByName(commonName);
	}

	@Test
	public void testViewAllPlants() throws InvalidEntityException {
		List<Plant> allPlants = new ArrayList<>();
		allPlants.add(new Plant());
		when(plantDao.viewAllPlants()).thenReturn(allPlants);

		List<Plant> result = plantService.viewAllPlants();
		Assertions.assertEquals(allPlants, result);
		verify(plantDao, times(1)).viewAllPlants();
	}

	@Test
	public void testViewAllPlantsByType() throws InvalidEntityException {
		String typeOfPlant = "TestType";
		List<Plant> plantsByType = new ArrayList<>();
		plantsByType.add(new Plant());
		when(plantDao.viewAllPlantsByType(typeOfPlant)).thenReturn(plantsByType);

		List<Plant> result = plantService.viewAllPlantsByType(typeOfPlant);

		Assertions.assertEquals(plantsByType, result);
		verify(plantDao, times(1)).viewAllPlantsByType(typeOfPlant);
	}

	@Test
	public void testAddPlant_WithInvalidEntityException() throws InvalidEntityException {
		Plant plantToAdd = new Plant();
		doThrow(InvalidEntityException.class).when(plantDao).addPlant(plantToAdd);

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.addPlant(plantToAdd));

		verify(plantDao, times(1)).addPlant(plantToAdd);
	}

	@Test
	public void testUpdatePlant_WithInvalidEntityException() throws InvalidEntityException {
		Plant plantToUpdate = new Plant();
		doThrow(InvalidEntityException.class).when(plantDao).updatePlant(plantToUpdate);

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.updatePlant(plantToUpdate));

		verify(plantDao, times(1)).updatePlant(plantToUpdate);
	}

	@Test
	public void testViewPlantById_WithInvalidEntityException() throws InvalidEntityException {
		Long plantId = 1L;
		doThrow(InvalidEntityException.class).when(plantDao).viewPlantById(plantId);

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.viewPlantById(plantId));

		verify(plantDao, times(1)).viewPlantById(plantId);
	}

	@Test
	public void testViewPlantByName_WithInvalidEntityException() throws InvalidEntityException {
		String commonName = "TestPlant";
		doThrow(InvalidEntityException.class).when(plantDao).viewPlantByName(commonName);

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.viewPlantByName(commonName));

		verify(plantDao, times(1)).viewPlantByName(commonName);
	}

	@Test
	public void testViewAllPlants_WithInvalidEntityException() throws InvalidEntityException {
		doThrow(InvalidEntityException.class).when(plantDao).viewAllPlants();

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.viewAllPlants());

		verify(plantDao, times(1)).viewAllPlants();
	}

	@Test
	public void testViewAllPlantsByType_WithInvalidEntityException() throws InvalidEntityException {
		String typeOfPlant = "TestType";
		doThrow(InvalidEntityException.class).when(plantDao).viewAllPlantsByType(typeOfPlant);

		Assertions.assertThrows(InvalidEntityException.class, () -> plantService.viewAllPlantsByType(typeOfPlant));

		verify(plantDao, times(1)).viewAllPlantsByType(typeOfPlant);
	}
}
//Final one