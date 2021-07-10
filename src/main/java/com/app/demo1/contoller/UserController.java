package com.app.demo1.contoller;

import com.app.demo1.Exception.UserExistException;
import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.Services.UserService;
import com.app.demo1.data.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class UserController {


    @Autowired
    UserService userService;


    /*
    Good for small set of record set, for large set we need implement some limit size
    or pagination
     */
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
    @PostMapping()
    public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
       try {
           return userService.createUser(userEntity);
       } catch (UserExistException ex){
           throw new ResponseStatusException(HttpStatus.FOUND, ex.getMessage());
       }
    }

    @GetMapping("/name/{firstName}")
    public List<UserEntity>getNameByPartialSearch(@PathVariable String firstName){
        return userService.getNameByPartialSearch(firstName);
    }
}
