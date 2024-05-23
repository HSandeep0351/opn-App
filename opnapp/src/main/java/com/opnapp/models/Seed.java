package com.opnapp.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seed")
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seedId;

	@NotBlank(message = "Seed Name is Mandatory...")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String commonName;

	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String bloomTime;

	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String watering;
	@Pattern(regexp = "EASY|MEDIUM|HARD", message = "Difficulty level should be EASY, MEDIUM, or HARD")
	private String difficultyLevel;

	@NotBlank(message = "Temperature Field is mandatory")
	private String temperature;

	@NotBlank(message = "Type of Seed field is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String typeOfSeed;

	private String description;

	@NotNull(message = "stock value can not be null")
	@Min(value = 0, message = "stock value must be greater than equal to 0")
	private Integer stock;

	@NotNull
	@Min(value = 1, message = "stock value must be greater than equal to 1")
	private Double cost;
	@Min(value = 1, message = "Seeds per packet should be at least 1")
	private Integer seedsPerPacket;

	@ManyToOne
	@JoinColumn(name = "planter_id")
	private Planter planter;

	private boolean isDeleted;

	public Seed() {

	}

	public Seed(String commonName, String bloomTime, String watering, String difficultyLevel, String temperature,
			String typeOfSeed, String description, Integer stock, Double cost, Integer seedsPerPacket,
			Planter planter) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeed = typeOfSeed;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
		this.planter = planter;
		this.isDeleted = false;
	}

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTypeOfSeed() {
		return typeOfSeed;
	}

	public void setTypeOfSeed(String typeOfSeed) {
		this.typeOfSeed = typeOfSeed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}