package com.opnapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opnapp.DAO.OrderDAO;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Order;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	private final OrderDAO orderDAO;

	@Autowired
	public OrderServiceImpl(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public Order addOrder(Order order) throws InvalidEntityException {
		logger.info("Adding order: {}", order);
		Double sum=order.getPlantCost()+order.getPlanterCost()+order.getSeedCost();
		order.setTotalCost(sum);
		return orderDAO.addOrder(order);
	}

	@Override
	public Order updateOrder(Order order) throws InvalidEntityException {
		logger.info("Updating order: {}", order);
		return orderDAO.updateOrder(order);
	}

	@Override
	public Order deleteOrder(Long orderId) throws InvalidEntityException {
		logger.info("Deleting order: {}", orderId);
		return orderDAO.deleteOrder(orderId);

	}

	@Override
	public Order viewOrder(Long orderId) throws InvalidEntityException {
		logger.info("Viewing order with ID: {}", orderId);
		return orderDAO.viewOrder(orderId);
	}

	@Override
	public List<Order> viewAllOrders() throws InvalidEntityException {
		logger.info("Viewing all orders");
		return orderDAO.viewAllOrders();
	}

	@Override
	public void cancelOrder(Long orderId) {
		logger.info("Cancelling Order");
		 orderDAO.cancelOrder(orderId);
		
	}

}