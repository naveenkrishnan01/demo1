package com.app.demo1.contoller;


import com.app.demo1.Services.EmployeeService;
import com.app.demo1.data.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @PostMapping
    public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createEmployee(employeeEntity);
    }
}
