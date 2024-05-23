package com.opnapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opnapp.models.Planter;

import jakarta.transaction.Transactional;

@Repository
public interface PlanterRepository extends JpaRepository<Planter, Long>{
	

    public List<Planter> findByIsDeleted(boolean f);
	
	@Transactional
	@Modifying
	@Query("UPDATE Planter p SET p.isDeleted = true WHERE p.planterId = :planterId")
	public void markAsDeleted(@Param("planterId") Long planterId);
	
	@Query("SELECT p FROM Planter p WHERE p.planterId = :planterId AND p.isDeleted = false")
	public Planter findPlanterById(Long planterId);
	
	public Optional<Planter> findById(Long planterId);
	
	@Query("SELECT p FROM Planter p WHERE p.planterShape = :planterShape AND p.isDeleted = false")
	public List<Planter> findByPlanterByPlanterShape(String planterShape);
	
	@Query("SELECT p FROM Planter p WHERE p.isDeleted = false AND p.planterCost BETWEEN :minCost AND :maxCost")
	public List<Planter> viewPlanterByCostRange(double minCost, double maxCost);

	
	

}
