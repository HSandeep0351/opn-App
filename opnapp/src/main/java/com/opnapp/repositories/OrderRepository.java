package com.opnapp.repositories;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opnapp.models.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByIsDeleted(boolean f);

	@Transactional
	 @Modifying
	    @Query("UPDATE Order o SET o.isDeleted = true WHERE o.bookingOrderId = :orderId")
	    public  void markAsDeleted(@Param("orderId") Long orderId);


	@Query("SELECT p FROM Order p WHERE p.bookingOrderId = :orderId AND p.isDeleted = false")
	public Order findOrderById(@Param("orderId") Long orderId);

}