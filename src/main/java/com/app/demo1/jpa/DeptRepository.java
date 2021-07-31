package com.app.demo1.jpa;

import com.app.demo1.data.DeptEntity;
import com.app.demo1.data.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DeptRepository extends CrudRepository<DeptEntity, Integer> {

    @Query("Select c, x from UserEntity c  Inner join DeptEntity x on c.id = x.UserId where UserId = :UserId")
    public Iterable<DeptEntity> findAllById(@Param("UserId")  Iterable UserId);
}
