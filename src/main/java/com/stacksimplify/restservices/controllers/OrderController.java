package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}/orders")
    public List<Order> getAllOrderBForUser(@PathVariable Long userId) throws UserNameNotFoundException {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent())
        {
            return optional.get().getOrders();
        }
        else
            throw new UserNameNotFoundException("User Not Found");
    }

    @PostMapping("/{id}/orders")
    public Order createOrder(@PathVariable Long id, @RequestBody Order order) throws UserNameNotFoundException {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent())
        {
            order.setUser(optional.get());
            return orderRepository.save(order);
        }
        else
            throw new UserNameNotFoundException("User Not Found");
    }

    @GetMapping("/{userId}/order/{orderid}")
    public Order getOrderById(@PathVariable Long userId, @PathVariable Long orderid) throws UserNameNotFoundException {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent())
        {
            System.out.println("inside if");
            //if(optional.get().getOrders().stream().filter(x->x.getOrderId()===orderid).count()>0)
                return orderRepository.findById(orderid).get();
        }
        else
            throw new UserNameNotFoundException("User Not Found");
    }
}
