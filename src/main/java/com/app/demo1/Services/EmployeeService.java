package com.app.demo1.Services;

import com.app.demo1.data.EmployeeEntity;
import com.app.demo1.jpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
         if(employeeEntity.getFullTime() == null) {
             employeeEntity.setFullTime("N");
         } else {
             employeeEntity.setFullTime(employeeEntity.getFullTime());
         }
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeEntity;
    }

}
