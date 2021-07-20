
package com.app.demo1.Services;

import com.app.demo1.Exception.UserExistException;
import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public Iterable<UserEntity> findAllUser() {
        Iterable<UserEntity> result = userRepository.findAll();
        return result;

    }

    public UserEntity createUser(UserEntity userEntity) throws UserExistException {
        checkForDuplicates(userEntity);
        userEntity = userRepository.save(userEntity);
        return userEntity;
    }

    public Optional<UserEntity> findByUserId(Integer Id) throws UserNotFoundException {
        Optional<UserEntity> userById = userRepository.findById(Id);
        if (!userById.isPresent()) throw new UserNotFoundException("User not found in the user Table");
        return userById;
    }

    public String deleteUserId(Integer id) {
        userRepository.deleteById(id);
        return "id removed from table.. " + id;
    }

    public List<UserEntity> getNameByPartialSearch(String firstName){
        return userRepository.findByPartialName(firstName);
    }

    public String updateUser(UserEntity userEntity) {
        UserEntity updateUser =
                userRepository.findById(userEntity.getId()).orElse(null);
                updateUser.setFirstName(userEntity.getFirstName());
                updateUser.setLastName(userEntity.getLastName());
                userRepository.save(updateUser);
                return "updated the user... ";
    }

    public void checkForDuplicates(UserEntity userEntity) throws UserExistException {
        if (userEntity.getFirstName() !=null){
            for(UserEntity search : findAllUser()){
                if(search.getFirstName().equalsIgnoreCase(userEntity.getFirstName())){
                    throw new UserExistException("User exist in the Table");
                }
            }
        }
    }
}