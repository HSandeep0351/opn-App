package com.opnapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opnapp.models.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findById(Long customerId);

	Customer findByUsernameAndPassword(String username, String password);

	List<Customer> findByIsDeleted(boolean f);

	// Customer markAsDeleted(Long id);
	@Transactional
	@Modifying
	@Query("UPDATE Customer a SET a.isDeleted = true WHERE a.id = :id")
	void markAsDeleted(@Param("id") Long id);

	@Query("SELECT c FROM Customer c WHERE c.id = :customerId AND c.isDeleted = false")
	Customer findActiveCustomerById(@Param("customerId") Long customerId);

	Customer findByEmail(String email);
}
