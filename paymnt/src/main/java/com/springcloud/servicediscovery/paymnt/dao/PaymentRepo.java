package com.springcloud.servicediscovery.paymnt.dao;

import com.springcloud.servicediscovery.paymnt.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {}