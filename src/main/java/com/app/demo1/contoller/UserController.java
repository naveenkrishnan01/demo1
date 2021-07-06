package com.app.demo1.contoller;

import com.app.demo1.Services.UserService;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class UserController {


    @Autowired
    UserService userService;

    /*
    Good for small set of record set, for large set we need implement some limit size
    or pagination
     */
    @GetMapping(value = "test")
    public Iterable<UserEntity> getUser() {
        return userService.findAllUser();
    }

   @GetMapping("/test/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Integer id) {
        return  userService.findByUserId(id);
    }

    /*
       Add a new record thru Post request . Api: http://localhost:8080/test
       json format Payload:  Header : Content-Type: application/json
       Body:
         {
        "id": 3,
         "firstName": "John",
         "lastName": "Rogers"
}
     */
    @PostMapping("/test")
    public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/name/{firstName}")
    public List<UserEntity>getNameByPartialSearch(@PathVariable String firstName){
        return userService.getNameByPartialSearch(firstName);
    }
}
