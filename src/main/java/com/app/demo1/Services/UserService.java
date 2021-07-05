
package com.app.demo1.Services;

import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<UserEntity> findAllUser() {

        Iterable<UserEntity> result = userRepository.findAll();
          return  result;

    }

    public UserEntity createUser(UserEntity userEntity) {
            userEntity = userRepository.save(userEntity);
            return userEntity;

    }

    public Optional<UserEntity> findByUserId(Integer Id) {
        Optional<UserEntity> userById = userRepository.findById(Id);
        if (userById.isPresent()){
            return userById;
        } else {
            System.out.println("Table is empty");  // log4j can be used to handle this for logging
        }
         return userById;
    }
}