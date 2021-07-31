package com.app.demo1.contoller;

import com.app.demo1.Services.DeptServices;
import com.app.demo1.data.DeptEntity;
import com.app.demo1.data.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value="/")
public class DeptController {

    @Autowired
    DeptServices deptServices;

    @GetMapping("/users/dept/{id}")
    public Iterable<DeptEntity>getUserByDeptId(@PathVariable Integer id) {
       return deptServices.getUserDept(Collections.singleton(id));
    }
}
