package com.demo1.demo1.RepositoryTest;

import com.app.demo1.Services.UserService;
import com.app.demo1.data.UserEntity;
import com.app.demo1.jpa.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
// The above configuration for mysql, telling spring not replace the database
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void testFindAll() {
     UserEntity userEntity = new UserEntity("Wayne", "Rooney");
     userRepository.save(userEntity);

     Iterable<UserEntity> userEntities = userService.findAllUser();
        Assertions.assertThat(userEntities).extracting(UserEntity::getFirstName).
                contains("Wayne");
        Assertions.assertThat(userEntities).extracting(UserEntity::getLastName).
                contains("Rooney");
    }
}
