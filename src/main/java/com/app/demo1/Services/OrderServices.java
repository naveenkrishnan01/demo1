package com.app.demo1.Services;

import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.data.OrderEntity;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    UserRepository userRepository;


    public List<OrderEntity> findByOrderId(Integer Id) throws UserNotFoundException {
        Optional<UserEntity> orderById = userRepository.findById(Id);
        if (!orderById.isPresent()) throw new UserNotFoundException("Order not found in the user Table");
        return orderById.get().getOrders();
    }
}
