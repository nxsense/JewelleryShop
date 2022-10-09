package service;

import entities.Order;

import java.util.List;
/**
 * @author author
 * @version 1.0
 */
public interface OrderService {
    Order findById(Long id);
    List<Order> findOrdersByUserId(int id);
    Order createOrder(Order order);
}
