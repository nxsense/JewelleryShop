package service.impl;

import entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import repository.UserRepository;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public Order findById(Long id) {
        Optional<Order> order= orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public List<Order> findOrdersByUserId(int id) {
        List<Order> orders = new ArrayList<>();
        orders = orderRepository.findByUserId(id);
        return orders;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
