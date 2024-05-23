package com.opnapp.DAO;

import java.util.List;

import com.opnapp.models.Order; 



public interface OrderDAO {
	public Order addOrder(Order order);
	 
	public Order updateOrder(Order order);
	 
	public Order deleteOrder (Long orderId);
	 
	public Order viewOrder(Long orderId);
	 
	public List<Order> viewAllOrders();

	public void cancelOrder(Long orderId);

}
