package com.opnapp.DAO;

import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;
import com.opnapp.repositories.PlanterRepository;
import com.opnapp.validators.PlanterValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class PlanterDAOImpl implements PlanterDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlanterDAOImpl.class);

    private final PlanterRepository planterRepository;

    @Autowired
    public PlanterDAOImpl(PlanterRepository planterRepository) {
        this.planterRepository = planterRepository;
    }

    @Override
    public Planter addPlanter(Planter planter) throws InvalidEntityException {
        PlanterValidator.validatePlanter(planter);
        LOGGER.info("Adding planter: {}", planter);
        Planter addedPlanter = planterRepository.save(planter);
        LOGGER.info("Planter added successfully: {}", addedPlanter);
        return addedPlanter; 
    }

    @Override
    public Planter updatePlanter(Planter planter) throws InvalidEntityException {
        PlanterValidator.validatePlanter(planter);
        LOGGER.info("Updating planter: {}", planter);
        Long planterId = planter.getPlanterId();
        Planter existingPlanter = planterRepository.findPlanterById(planterId);
        if (existingPlanter == null) {
            throw new InvalidEntityException("Planter " + planter.getPlanterId() + " doesn't exist");
        } else {
			existingPlanter.setPlanterHeight(planter.getPlanterHeight());
			existingPlanter.setPlanterCapacity(planter.getPlanterCapacity());
			existingPlanter.setPlanterHoles(planter.getPlanterHoles());
			existingPlanter.setPlanterColor(planter.getPlanterColor());
			existingPlanter.setPlanterShape(planter.getPlanterShape());
			existingPlanter.setPlanterStock(planter.getPlanterStock());
			existingPlanter.setPlanterCost(planter.getPlanterCost());
			existingPlanter.setIsDeleted(planter.getIsDeleted());
			 Planter updatedPlanter = planterRepository.save(existingPlanter);
	            LOGGER.info("Planter updated successfully: {}", updatedPlanter);
	            return updatedPlanter;
	        }
	    }

	    @Override
	    public Planter deletePlanter(Long planterId) throws InvalidEntityException {
	    	Planter deletedPlanter = planterRepository.findById(planterId).get();
	    	if(deletedPlanter.getIsDeleted()!=true) {
	        LOGGER.info("Deleting planter with ID: {}", planterId);
	        planterRepository.markAsDeleted(planterId);
	        LOGGER.info("Planter deleted successfully with ID: {}",planterId);
	        }else {
	        	throw new InvalidEntityException("PlanterId not found");
	        }
	        return deletedPlanter;
	    }

	    @Override
	    public Planter viewPlanterById(Long planterId) throws InvalidEntityException {
	    	PlanterValidator.viewPlanterById(planterId);
	        LOGGER.info("Viewing planter by ID: {}", planterId);
	        Planter viewedPlanter = planterRepository.findPlanterById(planterId);
	        if (viewedPlanter == null) {
	        	 LOGGER.warn("Planter with ID {} not found", planterId);
	        	throw new InvalidEntityException("Planter with ID " +planterId+ " not found");
	        } else {
	            LOGGER.info("Planter viewed successfully: {}", viewedPlanter);
	        }
	        return viewedPlanter;
	    }

	    @Override
	    public List<Planter> viewPlanterByShape(String planterShape) throws InvalidEntityException {
	        PlanterValidator.validatePlanter(planterShape);
	        LOGGER.info("Viewing planters by shape: {}", planterShape);
	        List<Planter> plantersByShape = planterRepository.findByPlanterByPlanterShape(planterShape);
	        if(plantersByShape.isEmpty()) {
	        	LOGGER.warn("Planter with Shape {} not found",planterShape);
	        	throw new InvalidEntityException("Planter with Shape " +planterShape+ " not found");
	        }
	        else {
	        LOGGER.info("Planters viewed successfully by shape: {}", plantersByShape.size());
	        }
	        return plantersByShape;
	    }

	    @Override
	    public List<Planter> viewAllPlanters() throws InvalidEntityException {
	        LOGGER.info("Viewing all planters");
	        List<Planter> allPlanters = planterRepository.findByIsDeleted(false);
	        LOGGER.info("All planters viewed successfully: {}", allPlanters.size());
	        return allPlanters;
	    }

	    @Override
	    public List<Planter> viewPlanterByCostRange(double minCost, double maxCost) throws InvalidEntityException {
	        PlanterValidator.validatePlanterByCost(minCost, maxCost);
	        LOGGER.info("Viewing planters by cost range: {} - {}", minCost, maxCost);
	        List<Planter> plantersByCostRange = planterRepository.viewPlanterByCostRange(minCost, maxCost);
	        if(plantersByCostRange.isEmpty()) {
	        	LOGGER.warn("Planter with mincost {} and maxcost {} not found",minCost,maxCost);
	        	throw new InvalidEntityException("Planter with cost " +minCost+ " and "+maxCost+ " not found");
	        }
	        else {
	        LOGGER.info("Planters viewed successfully by cost range: {}", plantersByCostRange.size());
	        }
	        return plantersByCostRange;
	    }
	}