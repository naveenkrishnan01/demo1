package com.app.demo1.contoller;

import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.Services.OrderServices;
import com.app.demo1.data.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping("/{id}/orders")
    public List<OrderEntity> getUserById(@PathVariable Integer id) {
        try {
            return orderServices.findByOrderId(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}

