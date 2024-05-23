package com.opnapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Order;
import com.opnapp.services.OrderService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws InvalidEntityException{

		Order addedOrder = orderService.addOrder(order);
		return ResponseEntity.ok(addedOrder);

	}

	@PutMapping("/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws InvalidEntityException{

		Order updatedOrder = orderService.updateOrder(order);
		return ResponseEntity.ok(updatedOrder);

	}

	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Long orderId) throws InvalidEntityException{
		Order deletOrders= orderService.deleteOrder(orderId);
		return ResponseEntity.ok(deletOrders);
	}

	 @GetMapping("view/{orderId}")
	    public ResponseEntity<Order> viewOrder(@PathVariable Long orderId) throws InvalidEntityException {
		 Order viewOrder = orderService.viewOrder(orderId);
	        return ResponseEntity.ok(viewOrder);
	    }
 
	    @GetMapping("/viewAll")
	    public ResponseEntity<List<Order>> viewAllOrders() throws InvalidEntityException{
	    	List<Order> viewAll = orderService.viewAllOrders();
	        return ResponseEntity.ok(viewAll);
	    }
	    
	    @PutMapping("/cancel/{orderId}")
	    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId){
			  orderService.cancelOrder(orderId);
			 return ResponseEntity.ok(orderService.viewOrder(orderId));
	    }
}
