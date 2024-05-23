package com.opnapp.validators;

import java.util.regex.Pattern;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Seed;

public class SeedValidator {

	public static void validateSeed(Seed seed) throws InvalidEntityException {
		if (seed == null) {
			throw new InvalidEntityException("Seed object is null");
		}

		if (!isValidStringType(seed.getCommonName())) {
			throw new InvalidEntityException(
					"Common name should not be empty and should contain only letters");
		}

		if (!isValidStringType(seed.getBloomTime())) {
			throw new InvalidEntityException("Bloom time should contain only letters");
		}
		if (!isValidStringType(seed.getDescription())) {
			throw new InvalidEntityException("Description should contain only letters");
		}

		if (!isValidStringType(seed.getWatering())) {
			throw new InvalidEntityException("Watering should contain only letters");
		}

		if (!isValidDifficultyLevel(seed.getDifficultyLevel())) {
			throw new InvalidEntityException("Difficulty level should be EASY, MEDIUM, or HARD");
		}

		if (!isValid(seed.getTemperature())) {
			throw new InvalidEntityException("Temperature should contain only numbers");
		}

		if (!isValidStringType(seed.getTypeOfSeed())) {
			throw new InvalidEntityException(
					"Type of seed should not be empty and should contain only letters");
		}

		if (!isValidInteger(seed.getStock())) {
            throw new InvalidEntityException("stock must be integer");
        }
		if (!isValidIntegerForDouble(seed.getCost())) {
            throw new InvalidEntityException("cost must be integer and greater than zero");
        }
		if (!isValidInteger(seed.getSeedsPerPacket())) {
            throw new InvalidEntityException("seedsPerPacket must be integer and greater than zero");
        }

		
	}
	private static boolean isValid(String temperature) {
		// TODO Auto-generated method stub
		return temperature!=null;
	}
	public static void validatetypeOfSeed(String typeOfSeed) throws InvalidEntityException {
		if (!isValidStringType(typeOfSeed)) {
			throw new InvalidEntityException(
					"Type of seed should not be empty and should contain only letters");
		}
	}
	public static void validateName(String commonName) throws InvalidEntityException {
		if (!isValidStringType(commonName)) {
			throw new InvalidEntityException(
					"Common Name should not be empty and should contain only letters");
		}
	}

	
	private static boolean isValidString(String value) {
		return value != null && Pattern.matches("^[A-Za-z]+$", value);
	}
	private static boolean isValidStringType(String value) {
		return value != null && Pattern.matches("^[A-Za-z ]+$", value);
	}
	private static boolean isValidInteger(Integer  value) {
        return value != null && value >=0 ;
    }
	private static boolean isValidIntegerForDouble(Double  value) {
        return value != null && value >=0 ;
    }

	private static boolean isValidDifficultyLevel(String value) {
		return value != null && Pattern.matches("EASY|MEDIUM|HARD", value);
	}
}
