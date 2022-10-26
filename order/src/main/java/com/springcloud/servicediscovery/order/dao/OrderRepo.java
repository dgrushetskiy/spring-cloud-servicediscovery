package com.springcloud.servicediscovery.order.dao;

import com.springcloud.servicediscovery.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {}
