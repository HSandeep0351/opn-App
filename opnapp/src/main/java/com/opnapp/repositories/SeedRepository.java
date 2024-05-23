package com.opnapp.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opnapp.models.Seed;

import jakarta.transaction.Transactional;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {

	List<Seed> findByIsDeleted(boolean f);

	@Transactional
	@Modifying
	@Query("UPDATE Seed s SET s.isDeleted = true WHERE s.seedId = :seedId")
	public void markAsDeleted(@Param("seedId") Long seedId);

	@Query("SELECT s FROM Seed s WHERE s.seedId = :seedId AND s.isDeleted = false")
	public Seed findSeedById(@Param("seedId")Long seedId);
	
	public Optional<Seed> findById(Long seedId);

	@Query("SELECT s FROM Seed s WHERE s.commonName = :commonName AND s.isDeleted = false")
	public List<Seed> findByCommonName(@Param("commonName") String commonName);

	@Query("SELECT s FROM Seed s WHERE s.typeOfSeed = :typeOfSeed AND s.isDeleted = false")
	public List<Seed> findAllByTypeOfSeed(@Param("typeOfSeed") String typeOfSeed);

}