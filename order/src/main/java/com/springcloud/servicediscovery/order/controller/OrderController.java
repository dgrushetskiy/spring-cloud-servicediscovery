package com.springcloud.servicediscovery.order.controller;

import com.springcloud.servicediscovery.order.dao.OrderRepo;
import com.springcloud.servicediscovery.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepo repo;

    @GetMapping("/orders")
    private List<Order> getAllStudents(){
        return (List<Order>) repo.findAll();
    }

    @PostMapping("/orders")
    private Order addOrder(@RequestBody Order newOrder){
        return repo.save(newOrder);
    }
}
