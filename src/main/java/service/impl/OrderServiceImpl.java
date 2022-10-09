package service.impl;

import entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import repository.UserRepository;
import service.OrderService;

import java.util.List;
import java.util.Optional;
/**
 * Implementation of orderService interface, where interaction with database for orders is described
 *
 * @author author
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    /**
     * Searching certain order by id
     *
     * @param id of the order we search
     */
    @Override
    public Order findById(Long id) {
        Optional<Order> order= orderRepository.findById(id);
        return order.orElse(null);
    }

    /**
     * Searching the list of items of some user
     * @param id of the user whose orders we want to find
     * @return list of all the orders that that user had made
     */
    @Override
    public List<Order> findOrdersByUserId(int id) {
        List<Order> orders;
        orders = orderRepository.findByUserId(id);
        return orders;
    }

    /**
     * Adding the order to the DB
     * @param order we want to save
     */
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
