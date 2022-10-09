package restControllers;

import dto.ItemDto;
import dto.OrderDto;
import dto.UserDto;
import entities.Item;
import entities.Order;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ItemService;
import service.OrderService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * REST-Controller for admin's actions like adding/deleting items or managing orders
 * @author author
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/admin/")
public class AdminController {

    private final UserService userService;
    private final OrderService orderService;
    private final ItemService itemService;

    /**
     * AdminController`s constructor
     *
     * @param userService user service for using its methods
     * @param orderService orders service for using its methods
     * @param itemService items service for using its methods
     */
    @Autowired
    public AdminController(UserService userService, OrderService orderService, ItemService itemService) {
        this.userService = userService;
        this.orderService = orderService;
        this.itemService = itemService;
    }

    /**
     * Endpoint for searching certain user
     *
     * @param id users id for searching them
     */
    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Endpoint for adding some items
     *
     */
    @PutMapping(value = "items/add")
    public ResponseEntity<ItemDto> addIItem(@RequestBody Item item){
        if(item == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        itemService.addItem(item);
        ItemDto result = ItemDto.fromItem(item);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Endpoint for deleting items
     *
     * @param id for searching items to delete
     */
    @DeleteMapping(value = "items/delete/{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable(name = "id") Long id){
        Item item = itemService.findById(id);
        if(item == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint for searching certain users orders
     * @param id finding some user
     */
    @GetMapping(value = "users/orders/{id}")
    public ResponseEntity<List<OrderDto>> getUsersOrders(@PathVariable(name = "id") int id){
        List<Order> orders = orderService.findOrdersByUserId(id);
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<OrderDto> result = new ArrayList<>();
        for (Order order: orders) {
            result.add(OrderDto.fromOrder(order));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
