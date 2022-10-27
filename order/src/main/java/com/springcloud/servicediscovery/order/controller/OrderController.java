package com.springcloud.servicediscovery.order.controller;

import com.springcloud.servicediscovery.order.dao.OrderRepo;
import com.springcloud.servicediscovery.order.model.Order;
import com.springcloud.servicediscovery.paymnt.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private OrderRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/orders")
    private List<Order> getAllStudents(){
        return (List<Order>) repo.findAll();
    }

    @PostMapping("/orders")
    private Order addOrder(@RequestBody Order newOrder){
        Order ordResp = repo.save(newOrder);

        Payment pmt = new Payment();
        pmt.setOrderId(ordResp.getOrderId());
        pmt.setPaymentAmt(ordResp.getPrice() * ordResp.getQuantity());

        Payment pmResp = restTemplate.postForObject("http://payment/payments", pmt, Payment.class);
        //Payment pmResp = restTemplate.postForObject("http://localhost:9002/payments", pmt, Payment.class);
        return repo.save(newOrder);
    }
}
