package com.opnapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Planter")
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planterId;

	@NotBlank(message = "Planter Height should not be null")
	@Min(value = 1, message = "Planter Height is must be greater than equal to 1")
	private Integer planterHeight;

	@NotBlank(message = "Planter capacity should not be null")
	@Min(value = 1, message = "Planter capacity is must be greater than equal to 1")
	private Integer planterCapacity;

	@NotBlank(message = "Planter Holes should not be null")
	@Min(value = 1, message = "Planter holes is must be greater than equal to 1")
	private Integer planterHoles;

	@NotBlank(message = "Planter Color should not be null")
	private String planterColor;

	@NotBlank(message = "Planter Shape should not be null")
	private String planterShape;

	@NotBlank(message = "Planter Stock should not be null")
	@Min(value = 0, message = "Planter stock is must be greater than equal to 1")
	private Integer planterStock;

	@NotBlank(message = "Planter Cost should not be null")
	@Min(value = 1, message = "Planter cost is must be greater than equal to 1")
	private Double planterCost;

	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "planter", cascade = CascadeType.ALL)
	private List<Plant> plants;

	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "planter", cascade = CascadeType.ALL)
	private List<Seed> seeds;

	private boolean isDeleted;

	public Planter() {

	}

	public Planter(Integer planterHeight, Integer planterCapacity, Integer planterHoles, String planterColor,
			String planterShape, Integer planterStock, Double planterCost, List<Plant> plants, List<Seed> seeds) {
		super();
		this.planterHeight = planterHeight;
		this.planterCapacity = planterCapacity;
		this.planterHoles = planterHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
		this.seeds = seeds;
		this.isDeleted = false;
	}

	public Integer getPlanterHeight() {
		return planterHeight;
	}

	public void setPlanterHeight(Integer planterHeight) {
		this.planterHeight = planterHeight;
	}

	public Integer getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(Integer planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public Integer getPlanterHoles() {
		return planterHoles;
	}

	public void setPlanterHoles(Integer planterHoles) {
		this.planterHoles = planterHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public Integer getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(Integer PlanterStock) {
		this.planterStock = PlanterStock;
	}

	public Double getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(Double PlanterCost) {
		this.planterCost = PlanterCost;
	}

	public Long getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Long planterId) {
		this.planterId = planterId;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
