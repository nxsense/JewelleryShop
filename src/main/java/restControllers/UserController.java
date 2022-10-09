package restControllers;

import dto.OrderDto;
import dto.UserDto;
import entities.Order;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderService;
import service.UserService;

/**
 * REST-controller for users actions like ordering items, registration etc.
 * @author author
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/profile")
public class UserController {
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    /**
     * Registering some new user
     *
     * @param user adding new user with needed information
     */
    @PutMapping(value = "register")
    public ResponseEntity<UserDto> registration(@RequestBody User user){
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if(userService.findByUsername(user.getUsername()) == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        userService.createUser(user);
        UserDto result = UserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    /**
     * Registering new order
     *
     * @param order adding new order with needed information
     */
    @PutMapping(value = "order")
    public ResponseEntity<OrderDto> newOrder(@RequestBody Order order){
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        orderService.createOrder(order);
        OrderDto result = OrderDto.fromOrder(order);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

}
