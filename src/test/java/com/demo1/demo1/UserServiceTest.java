package com.demo1.demo1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.demo1.Services.UserService;
import com.app.demo1.contoller.UserController;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserService dao;

    @Test
    public void testCreateUser() {
        //Given
        List<UserEntity> userList = new ArrayList<UserEntity>();
        UserEntity userOne = new UserEntity("Tom", "Rooney");
        UserEntity userTwo = new UserEntity("Marco", "Bastein");
        UserEntity userThree = new UserEntity("Leonard", "Vinci");

        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);

        //When
        when(dao.findAllUser()).thenReturn(userList);

        //Then - Assertions for all the methods in UserService
        assertEquals(3, userList.size());
        when(dao.createUser(userOne)).thenReturn(userOne);
        when(dao.findByUserId(1)).thenReturn(userList.stream().findFirst());


    }

    @Test
    public void testOnePartialSearch() {
        List<UserEntity> partialList = new ArrayList<>();
        UserEntity partialOne = new UserEntity("wayne", "Rooney");
        partialList.add(partialOne);

        when(dao.getNameByPartialSearch("way")).thenReturn(partialList);
    }

    @Test
    public void testMultiplePartialSearch() {
        List<UserEntity> multipleList = new ArrayList<>();
        UserEntity listOne = new UserEntity("Roger", "Federer");
        UserEntity listtwo = new UserEntity("Roger1", "Federer1");

        multipleList.add(listOne);
        multipleList.add(listtwo);

        when(dao.getNameByPartialSearch("Rog")).thenReturn(multipleList);

        assertEquals(2, multipleList.size());

    }
}
