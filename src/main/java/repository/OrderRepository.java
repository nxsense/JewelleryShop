package repository;

import entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author author
 * @version 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders where userid = ?1", nativeQuery = true)
    List<Order> findByUserId (Integer id);
}
