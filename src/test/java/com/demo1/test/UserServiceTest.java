/*
package com.demo1.test;

import com.app.demo1.Exception.UserNotFoundException;
import com.app.demo1.Services.DeptServices;
import com.app.demo1.Services.UserService;
import com.app.demo1.data.DeptEntity;
import com.app.demo1.data.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    UserService userService;

    @Mock
    DeptServices deptServices;


    @Test
    public void testMultipleUserService() throws UserNotFoundException {

        List<DeptEntity> deptList1 = new ArrayList<DeptEntity>();
        DeptEntity dept1 = new DeptEntity(101, "hISTORY", "HISTORYDEPT", 1);
        List<DeptEntity> deptList2 = new ArrayList<DeptEntity>();
        DeptEntity dept2 = new DeptEntity(102, "hISTORY-2", "WorldWar", 2);
        List<DeptEntity> deptList3= new ArrayList<DeptEntity>();
        DeptEntity dept3 = new DeptEntity(102, "hISTORY-3", "Peace", 3);
        deptList1.add(dept1);
        deptList2.add(dept2);
        deptList3.add(dept3);

        List<UserEntity> userList = new ArrayList<>();
        UserEntity userone = new UserEntity("John", "wayne", deptList1);
        UserEntity usertwo = new UserEntity("Roger", "maxine", deptList2);
        UserEntity userthree = new UserEntity("Mat", "Wilander", deptList3);
        userList.add(userone);
        userList.add(usertwo);
        userList.add(userthree);

        when(userService.findAllUser()).thenReturn(userList);

        assertEquals(3, userList.size());
        when(userService.findByUserId(1)).thenReturn(userList.stream().findFirst());
        when(userService.findAllUser()).thenReturn(userList);
    }

    @Test
    public void testUserService() throws UserNotFoundException {

        List<DeptEntity> deptList = new ArrayList<>();
        deptList.add(new DeptEntity(101, "hISTORY", "HISTORYDEPT", 1));
        deptList.add(new DeptEntity(101, "hISTORY2", "HISTORYDEPT2", 1));

        List<UserEntity> userList = new ArrayList<>();
        UserEntity userone = new UserEntity("John", "wayne", deptList);
        userList.add(userone);

        when(userService.findAllUser()).thenReturn(userList);

        assertEquals(1, userList.size());
        when(userService.findByUserId(1)).thenReturn(userList.stream().findFirst());
        when(userService.findAllUser()).thenReturn(userList);


    }
}
*/
