package com.opnapp.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opnapp.models.Plant;

import jakarta.transaction.Transactional;

public interface PlantRepo extends JpaRepository<Plant, Long>{
	
    List<Plant> findByIsDeleted(boolean f);
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant a SET a.isDeleted =true WHERE a.plantId = :plantId")
	public void markAsDeleted(@Param("plantId") Long plantId);
	
	public Optional<Plant> findById(Long plantId);

	@Query("SELECT p FROM Plant p WHERE p.commonName = :commonName AND p.isDeleted = false")
    public List<Plant> findBycommonName(@Param("commonName") String commonName);

	@Query("SELECT p FROM Plant p WHERE p.plantId = :plantId AND p.isDeleted = false")
	public Plant findPlantById(Long plantId);
	
	@Query("SELECT p FROM Plant p WHERE p.typeOfPlant = :typeOfPlant AND p.isDeleted = false")
	public List<Plant> findAllByTypeOfPlant(@Param("typeOfPlant") String typeOfPlant);
}

//Final One
