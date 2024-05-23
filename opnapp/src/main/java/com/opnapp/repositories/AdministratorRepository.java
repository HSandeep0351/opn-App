package com.opnapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import com.opnapp.models.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
	@Transactional
    @Modifying
    @Query("UPDATE Administrator a SET a.adminUserId = :newUserId, a.adminPassword = :newPassword WHERE a.adminId = :adminId")
    void updateAdministrator(@Param("adminId") Long adminId, @Param("newUserId") String newUserId, @Param("newPassword") String newPassword);

	List<Administrator> findByIsDeleted(boolean f);
	
	@Transactional
	@Modifying
	@Query("UPDATE Administrator a SET a.isDeleted = true WHERE a.adminId = :adminId")
	void markAsDeleted(@Param("adminId") Long adminId);
	
	Administrator findByAdminUserId(String username);
}
