package com.springcloud.servicediscovery.paymnt.controller;

import com.springcloud.servicediscovery.paymnt.dao.PaymentRepo;
import com.springcloud.servicediscovery.paymnt.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentRepo repo;

    @GetMapping("/payments")
    private List<Payment> getAllPayments(){
        return (List<Payment>) repo.findAll();
    }

    @PostMapping("/payments")
    private Payment addPayment(@RequestBody Payment newPayment){
        return repo.save(newPayment);
    }
}
