package com.app.demo1.jpa;

import com.app.demo1.data.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
