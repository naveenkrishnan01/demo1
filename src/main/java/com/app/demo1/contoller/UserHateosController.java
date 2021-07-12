package com.app.demo1.contoller;

import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.Services.UserService;
import com.app.demo1.data.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(value = "/hateos")
public class UserHateosController {

    UserService userService;

    @GetMapping()
    public Iterable<UserEntity> getUser() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Integer id) {
        try {
            return userService.findByUserId(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

}
