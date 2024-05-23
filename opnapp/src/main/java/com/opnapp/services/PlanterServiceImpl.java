package com.opnapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opnapp.DAO.PlanterDAOImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PlanterServiceImpl implements PlanterService {

	private final PlanterDAOImpl planterDAOImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanterServiceImpl.class);

	@Autowired
	public PlanterServiceImpl(PlanterDAOImpl planterDAOImpl) {
		this.planterDAOImpl = planterDAOImpl;
	}

	@Override
	public Planter addPlanter(Planter planter) throws InvalidEntityException {
		LOGGER.info("Adding planter: {}", planter);
		return planterDAOImpl.addPlanter(planter);
	}

	@Override
	public Planter updatePlanter(Planter planter) throws InvalidEntityException {
		LOGGER.info("Updating planter: {}", planter);
		Planter existingPlanter = planterDAOImpl.updatePlanter(planter);
		return existingPlanter;
	}

	@Override
	public Planter deletePlanter(Long planterId) throws InvalidEntityException {
		LOGGER.info("Deleting planter: {}", planterId);
		return planterDAOImpl.deletePlanter(planterId);

	}

	@Override
	public Planter viewPlanterById(Long planterId) throws InvalidEntityException {
		LOGGER.info("Viewing planter by ID: {}", planterId);
		return planterDAOImpl.viewPlanterById(planterId);
	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws InvalidEntityException {
		LOGGER.info("Viewing planter by shape: {}", planterShape);
		return planterDAOImpl.viewPlanterByShape(planterShape);
	}

	@Override
	public List<Planter> viewAllPlanters() throws InvalidEntityException {
		LOGGER.info("Viewing all planters");
		return planterDAOImpl.viewAllPlanters();
	}

	@Override
	public List<Planter> viewPlanterByCostRange(double minCost, double maxCost) throws InvalidEntityException {
		LOGGER.info("Viewing planters by cost range: {} - {}", minCost, maxCost);
		return planterDAOImpl.viewPlanterByCostRange(minCost, maxCost);
	}
}