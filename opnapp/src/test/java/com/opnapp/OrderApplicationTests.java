package com.opnapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.opnapp.DAO.OrderDAOImpl;
import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Order;
import com.opnapp.services.OrderServiceImpl;

class OrderApplicationTests {
	@Mock
    private OrderDAOImpl orderDAO;
 
    @InjectMocks
    private OrderServiceImpl orderService;
 
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testAddOrder() throws InvalidEntityException {
    	Order order = new Order();
        when(orderDAO.addOrder(order)).thenReturn(order);
 
        Order addedOrder = orderService.addOrder(order);
 
        assertEquals(order, addedOrder);
    }
 
    @Test
    public void testUpdateOrder() throws InvalidEntityException {
    	Order order = new Order();
        when(orderDAO.updateOrder(order)).thenReturn(order);
 
        Order updatedOrder = orderService.updateOrder(order);
 
        assertEquals(order, updatedOrder);
    }
 
    @Test
    public void testDeleteOrderWithException() throws InvalidEntityException {
        Long orderId = 1L;
        doThrow(InvalidEntityException.class).when(orderDAO).deleteOrder(orderId);
        
        Assertions.assertThrows(InvalidEntityException.class, () -> {
            orderService.deleteOrder(orderId);
        });
    }
    
 
	@Test
    public void testViewOrderById() throws InvalidEntityException {
        Long orderId = 1L; 
        Order mockedOrder = new Order();
        when(orderDAO.viewOrder(orderId)).thenReturn(mockedOrder);
 
        Order viewedPlanter = orderService.viewOrder(orderId);
 
        assertEquals(mockedOrder, viewedPlanter);
    }
 
    
    @Test
    public void testViewAllOrders() throws InvalidEntityException {
        List<Order> mockedorder = new ArrayList<>();
        when(orderDAO.viewAllOrders()).thenReturn(mockedorder);
 
        List<Order> allOrders = orderService.viewAllOrders();
 
        assertEquals(mockedorder, allOrders);
    }
    
    @Test
    public void testAddOrder_WithInvalidEntityException() throws InvalidEntityException {
        Order orderToAdd = new Order();
        doThrow(InvalidEntityException.class).when(orderDAO).addOrder(orderToAdd);

        Assertions.assertThrows(InvalidEntityException.class, () -> orderService.addOrder(orderToAdd));

        verify(orderDAO, times(1)).addOrder(orderToAdd);
    }

    @Test
    public void testUpdateOrder_WithInvalidEntityException() throws InvalidEntityException {
        Order orderToUpdate = new Order();
        doThrow(InvalidEntityException.class).when(orderDAO).updateOrder(orderToUpdate);

        Assertions.assertThrows(InvalidEntityException.class, () -> orderService.updateOrder(orderToUpdate));

        verify(orderDAO, times(1)).updateOrder(orderToUpdate);
    }

   

    @Test
    public void testViewOrderById_WithInvalidEntityException() throws InvalidEntityException {
        Long orderId = 1L;
        doThrow(InvalidEntityException.class).when(orderDAO).viewOrder(orderId);

        Assertions.assertThrows(InvalidEntityException.class, () -> orderService.viewOrder(orderId));

        verify(orderDAO, times(1)).viewOrder(orderId);
    }

    @Test
    public void testViewAllOrders_WithInvalidEntityException() throws InvalidEntityException {
        doThrow(InvalidEntityException.class).when(orderDAO).viewAllOrders();

        Assertions.assertThrows(InvalidEntityException.class, () -> orderService.viewAllOrders());

        verify(orderDAO, times(1)).viewAllOrders();
    }
    
    @Test
    public void testDeleteOrder_WithInvalidEntityException() throws InvalidEntityException {
        Long orderId = 1L;
        doThrow(InvalidEntityException.class).when(orderDAO).deleteOrder(orderId);

        Assertions.assertThrows(InvalidEntityException.class, () -> orderService.deleteOrder(orderId));

        verify(orderDAO, times(1)).deleteOrder(orderId);
    }

 
    
}