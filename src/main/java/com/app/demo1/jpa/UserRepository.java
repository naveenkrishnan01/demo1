package com.app.demo1.jpa;

import com.app.demo1.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query("SELECT u from UserEntity u WHERE u.firstName LIKE CONCAT('%',:firstName,'%')")
    List<UserEntity> findByPartialName(@Param("firstName") String firstName);
}
