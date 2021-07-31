package com.app.demo1.Services;

import com.app.demo1.data.DeptEntity;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServices {

    @Autowired
    DeptRepository deptRepository;

    public Iterable<DeptEntity> getUserDept(Iterable<Integer> id) {
        return deptRepository.findAllById(id);
    }
}
