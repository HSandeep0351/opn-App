package com.opnapp.DAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Order;
import com.opnapp.repositories.OrderRepository;
import com.opnapp.validators.OrderValidator;


@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

	private final OrderRepository orderRepository;

	@Autowired
	public OrderDAOImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order addOrder(Order order) throws InvalidEntityException {
		OrderValidator.validateOrder(order);
		Order savedOrder = orderRepository.save(order);
		logger.info("Order added successfully: {}", savedOrder);
		return savedOrder;
	}

	@Override
	public Order updateOrder(Order order) throws InvalidEntityException {
		OrderValidator.validateOrder(order);
		logger.info("Updating order: {}", order);

		Long orderId = order.getBookingOrderId();
		Order existingOrder = orderRepository.findById(orderId).orElse(null);

		if (existingOrder == null) {
			throw new InvalidEntityException("Order " + orderId + " doesn't exist");
		} else {
			existingOrder.setOrderDate(order.getOrderDate());
			existingOrder.setTransactionMode(order.getTransactionMode());
//			existingOrder.setQuantity(order.getQuantity());
			
			existingOrder.setTotalCost(order.getTotalCost());
			existingOrder.setIsDeleted(order.getIsDeleted());
			existingOrder.setPlantCost(order.getPlantCost());
			existingOrder.setPlanterCost(order.getPlanterCost());
			existingOrder.setSeedCost(order.getSeedCost());

			Order updatedOrder = orderRepository.save(existingOrder);

			logger.info("Order updated successfully: {}", updatedOrder);

			return updatedOrder;
		}
	}

	@Override
    public Order deleteOrder(Long orderId) throws InvalidEntityException {
        Order delOrder = orderRepository.findById(orderId).get();
        if(delOrder.getIsDeleted()!=true) {
          	 logger.info("Deleting order with ID: {}", orderId);
          	orderRepository.markAsDeleted(orderId);
          	 logger.info("Order deleted successfully with ID: {}", orderId);
   	        }else {
   	        	throw new InvalidEntityException("orderId not found");
   	        }
        return delOrder;
    }

	@Override
	public Order viewOrder(Long orderId) throws InvalidEntityException {
		
		Order foundOrder = orderRepository.findOrderById(orderId);
		if (foundOrder != null) {
			logger.info("Order found successfully: {}", foundOrder);
		} else {
			
			logger.info("Order not found with ID: {}", orderId);
			throw new InvalidEntityException("Order not found with ID " +orderId);
		}
		return foundOrder;
	}

	@Override
	public List<Order> viewAllOrders() throws InvalidEntityException {
		List<Order> allOrders = orderRepository.findByIsDeleted(false);
		logger.info("Retrieved all orders successfully. Total orders: {}", allOrders.size());
		return allOrders;
	}

	@Override
	public void cancelOrder(Long orderId) {
		
		Order existingOrder = orderRepository.findById(orderId).orElse(null);

		if (existingOrder == null) {
			throw new InvalidEntityException("Order " + orderId + " doesn't exist");
		} else {
			existingOrder.setStatus("cancelled");
			orderRepository.save(existingOrder);
			logger.info("Order cancelled successfully");
	}

}
}