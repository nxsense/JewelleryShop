package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.Order;
import lombok.Data;

/**
 * DTO for orders
 *
 * @author author
 * @version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private int id;
    private int userId;
    private int itemId;
    private boolean completed;

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUserId());
        orderDto.setItemId(order.getItemId());
        orderDto.setCompleted(order.isCompleted());
        return orderDto;
    }

    public Order toOrder() {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setItemId(itemId);
        order.setCompleted(completed);
        return order;
    }

}
