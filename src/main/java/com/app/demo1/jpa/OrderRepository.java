package com.app.demo1.jpa;

import com.app.demo1.data.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

}
