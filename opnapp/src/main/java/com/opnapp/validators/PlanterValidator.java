package com.opnapp.validators;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;

import java.util.regex.Pattern;

public class PlanterValidator {

	public static void validatePlanter(Planter planter) throws InvalidEntityException {
		if (planter == null) {
			throw new InvalidEntityException("Planter object is null");
		}

		if (!isValidInteger(planter.getPlanterHeight())) {
			throw new InvalidEntityException("Planter height should be a positive integer");
		}

		if (!isValidInteger(planter.getPlanterCapacity())) {
			throw new InvalidEntityException("Planter capacity should be a positive integer");
		}

		if (!isValidInteger(planter.getPlanterHoles())) {
			throw new InvalidEntityException("Planter holes should be a positive integer");
		}

		if (!isValidNonNegativeInteger(planter.getPlanterStock())) {
			throw new InvalidEntityException("Planter stock should be a non-negative integer");
		}

		if (!isValidPositiveDouble(planter.getPlanterCost())) {
			throw new InvalidEntityException("Planter cost should be a positive number");
		}

		if (!isValidString(planter.getPlanterColor())) {
			throw new InvalidEntityException("Planter color should not be empty and should contain only letters");
		}

		if (!isValidString(planter.getPlanterShape())) {
			throw new InvalidEntityException("Planter shape should not be empty and should contain only letters");
		}

	
	}

	public static void validatePlanter(String planterShape) throws InvalidEntityException {

		if (!isValidString(planterShape)) {
			throw new InvalidEntityException("Planter shape should not be empty and should contain only letters");
		}
	}

	public static void validatePlanterByCost(double minCost, double maxCost) throws InvalidEntityException {

		if (!isValidStringByCost(minCost, maxCost)) {
			throw new InvalidEntityException(
					"Planter minCost and minCost should not be empty and should contain only numbers minCost must less than maxCost");
		}
	}

	public static void validatePlanterById(Long planterId) throws InvalidEntityException {

		if (!isValidLongById(planterId)) {
			throw new InvalidEntityException("Enter valid planter Id");
		}
	}

	private static boolean isValidLongById(Long planterId) {
	
		return planterId != null && planterId >= 0;
	}

	private static boolean isValidStringByCost(double minCost, double maxCost) {

		return minCost > 0 && maxCost > 0 && minCost <= maxCost;
	}

	private static boolean isValidInteger(Integer value) {
		return value != null && value > 0;
	}

	private static boolean isValidNonNegativeInteger(Integer value) {
		return value != null && value.doubleValue() == value.intValue() && value >= 0;
	}

	private static boolean isValidNonNegativeInteger(Long value) {
		return value != null && value >= 0;
	}

	private static boolean isValidPositiveDouble(Double value) {
		return value != null && value.doubleValue() == value.intValue() && value > 0;
	}

	private static boolean isValidString(String value) {
		return value != null && !value.isEmpty() && Pattern.matches("[a-zA-Z]+", value);
	}

	public static void viewPlanterById(Long planterId) {
		if (!isValidNonNegativeInteger(planterId)) {
			throw new InvalidEntityException("Planter id must be integer");
		}

	}
}
