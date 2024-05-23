package com.opnapp.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingOrderId;

	@NotNull(message = "Order Date cannot be null")
	private LocalDate orderDate;

	@Min(value=0 , message="Plant Quantity must be at least 0")
	private Double plantCost;
	
	@Min(value=0 , message="Seed Quantity must be at least 0")
	private Double seedCost;
	
	@Min(value=0 , message="Planter Quantity must be at least 0")
	private Double planterCost;
	
	private String status;
	
	
	@NotBlank(message = "Transaction Mode cannot be blank")
	private String transactionMode;

	@DecimalMin(value = "0", message = "Total Cost must be greater than equal to 0")
	private double totalCost;

	private boolean isDeleted;

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Order() {
		isDeleted = false;
		status = "active";
		this.orderDate = LocalDate.now();

	}

	public Long getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Long bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(Double plantCost) {
		this.plantCost = plantCost;
	}

	public Double getSeedCost() {
		return seedCost;
	}

	public void setSeedCost(Double seedCost) {
		this.seedCost = seedCost;
	}

	public Double getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(Double planterCost) {
		this.planterCost = planterCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
