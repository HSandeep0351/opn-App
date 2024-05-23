package com.opnapp.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Order;

public class OrderValidator {

	public static void validateOrder(Order order) throws InvalidEntityException {
		if (order == null) {
			throw new InvalidEntityException("Order object is null");
		}
		if (!validateOrderDate(order.getOrderDate())) {
			throw new InvalidEntityException("Order date must in YYYY-MM-DD");
		}

		if (!validateTransactionMode(order.getTransactionMode())) {
			throw new InvalidEntityException("Trasaction modes must be 'Cash' OR 'Credit Card'");

		}
		
		if (!validatePlantCost(order.getPlantCost())) {
			throw new InvalidEntityException("Quantity must be Integers and atleast '0'");

		}
		
		if (!validatePlanterCost(order.getPlanterCost())) {
			throw new InvalidEntityException("Quantity must be Integers and atleast '0'");

		}
		
		if (!validateSeedCost(order.getSeedCost())) {
			throw new InvalidEntityException("Quantity must be Integers and atleast '0'");

		}
		
		if (!validateTotalCost(order.getTotalCost())) {
			throw new InvalidEntityException("Cost cannot be null and be Positive Number");
		}
		
		if (!validateStatus(order.getStatus())) {
			throw new InvalidEntityException("Status must be either 'active' or 'cancelled'");

		}
	}

	private static boolean validateStatus(String status) {
		return status.equals("active") || status.equals("cancelled");
	}

	private static boolean validateSeedCost(Double seedCost) {
		return seedCost >= 0 ;
	}

	private static boolean validatePlanterCost(Double planterCost) {
		return planterCost >= 0 ;
	}

	private static boolean validatePlantCost(Double plantCost) {
		return plantCost >= 0 ;
	}

	private static Boolean validateOrderDate(LocalDate orderDate) throws InvalidEntityException {
		try {
			if (orderDate != null) {

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				orderDate.format(formatter);
				return true;
			} else {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean validateTransactionMode(String transactionMode) {
		return ("Cash".equals(transactionMode) || "Credit Card".equals(transactionMode));
	}

//	public static boolean validateQuantity(int quantity) {
//		return quantity >= 1 && quantity != 0;
//	}

	public static boolean validateTotalCost(double totalCost) {
		return totalCost > 0;
	}

	public static void validateOrderById(Long orderId) throws InvalidEntityException {
		if (!isValidLongById(orderId)) {
			throw new InvalidEntityException("Enter valid Order Id");

		}
	}

	private static boolean isValidLongById(Long orderId) {

		return orderId != null || orderId >= 0;
	}
	
	
	
	
	
	
	

}
