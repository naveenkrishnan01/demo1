package com.demo1.demo1.ControllerTest;


import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.Services.UserService;
import com.app.demo1.contoller.UserController;
import com.app.demo1.data.UserEntity;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @BeforeEach
    void setup() {

    }

    @Test
    @DisplayName("/GET findAll() success")
    void testFindAll() throws Exception {
        List<UserEntity> userEnt = new ArrayList<>();
        UserEntity userEntity1 = new UserEntity("tommy", "holfiger");
        UserEntity userEntity2 = new UserEntity("morris", "tony");
        userEnt.add(userEntity1);
        userEnt.add(userEntity2);

        Mockito.when(userService.findAllUser()).thenReturn(userEnt);
        mockMvc.perform(get("/test")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", Matchers.hasSize(2))).
                andExpect(jsonPath("$[0].firstName", Matchers.is("tommy")));

    }

    @Test
    void testFindById() throws Exception {

        UserEntity userEntity = new UserEntity("Roger", "Federer");
        Mockito.when(userService.findByUserId(1)).thenReturn(Optional.of(userEntity));

        mockMvc.perform(MockMvcRequestBuilders.get("/test/1"))
                .andExpect(status().isOk());


    }
}
