package com.opnapp;

import static org.mockito.Mockito.doThrow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.opnapp.DAO.PlanterDAOImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;
import com.opnapp.services.PlanterServiceImpl;


public class PlanterTests {

    @Mock
    private PlanterDAOImpl planterDAO;

    @InjectMocks
    private PlanterServiceImpl planterService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPlanterWithException() throws InvalidEntityException {
        Planter planterToAdd = new Planter();
        doThrow(InvalidEntityException.class).when(planterDAO).addPlanter(planterToAdd);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.addPlanter(planterToAdd);
        });
    }

    @Test
    public void testUpdatePlanterWithException() throws InvalidEntityException {
        Planter existingPlanter = new Planter();
        doThrow(InvalidEntityException.class).when(planterDAO).updatePlanter(existingPlanter);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.updatePlanter(existingPlanter);
        });
    }

    @Test
    public void testDeletePlanterWithException() throws InvalidEntityException {
        Planter planterToDelete = new Planter();
        doThrow(InvalidEntityException.class).when(planterDAO).deletePlanter(planterToDelete.getPlanterId());
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.deletePlanter(planterToDelete.getPlanterId());
        });
    }

    @Test
    public void testViewPlanterByIdWithException() throws InvalidEntityException {
        Long planterId = 1L;
        doThrow(InvalidEntityException.class).when(planterDAO).viewPlanterById(planterId);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.viewPlanterById(planterId);
        });
    }
    @Test
    public void testViewPlanterByShapeWithException() throws InvalidEntityException {
        String planterShape = "Round";
        doThrow(InvalidEntityException.class).when(planterDAO).viewPlanterByShape(planterShape);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.viewPlanterByShape(planterShape);
        });
    }
    @Test
    public void testViewAllPlantersWithException() throws InvalidEntityException {
        doThrow(InvalidEntityException.class).when(planterDAO).viewAllPlanters();
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.viewAllPlanters();
        });
    }
    @Test
    public void testViewPlanterByCostRangeWithException() throws InvalidEntityException {
        double minCost = 10.0;
        double maxCost = 20.0;
        doThrow(InvalidEntityException.class).when(planterDAO).viewPlanterByCostRange(minCost, maxCost);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            planterService.viewPlanterByCostRange(minCost, maxCost);
        });
    }
   
}
