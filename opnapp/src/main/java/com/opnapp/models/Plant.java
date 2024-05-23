package com.opnapp.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plant")
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long plantId;

	@NotBlank(message = "plant height can not be null")
	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private Integer plantHeight;
	private String bloomTime;

	@NotBlank(message = "TypeOfPlant can not be blank")
//	@Pattern(regexp = "[a-z]" , message = "TypeOfPlant must contain only lower or upper case alphabet")
	private String typeOfPlant;

	@NotBlank(message = "Plant name can not be blank")
//	@Pattern(regexp = "[a-zA-Z]" , message = "Plant Name must contain only lower or upper case alphabet")
	private String commonName;
	private String Exposure;
	private String flowerColor;
	private String temperature;
	private String description;

	@NotBlank(message = "Plant Stock can not be null")
	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private Integer plantsStock;

	@NotBlank(message = "plant cost can not be null")
	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private Double plantCost;

	@ManyToOne
	@JoinColumn(name = "planter_id")
	private Planter planter;

	private boolean isDeleted;

	public Plant() {

	}

	public Plant(Integer plantHeight, String bloomTime, String typeOfPlant, String commonName, String Exposure,
			String flowerColor, String temperature, String description, Integer plantsStock, Double plantCost,
			Planter planter) {

		this.plantHeight = plantHeight;
		this.bloomTime = bloomTime;
		this.typeOfPlant = typeOfPlant;
		this.commonName = commonName;
		this.Exposure = Exposure;
		this.flowerColor = flowerColor;
		this.temperature = temperature;
		this.description = description;
		this.plantsStock = plantsStock;
		this.plantCost = plantCost;
		this.planter = planter;
		this.isDeleted = false;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getExposure() {
		return Exposure;
	}

	public void setExposure(String Exposure) {
		this.Exposure = Exposure;
	}

	public String getFlowerColor() {
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

	public Double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(Double plantCost) {
		this.plantCost = plantCost;
	}

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
//Final one 