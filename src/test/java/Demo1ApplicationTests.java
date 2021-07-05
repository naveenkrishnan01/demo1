import com.Demo1Application;
import com.app.demo1.contoller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Demo1Application.class)

class Demo1ApplicationTests {

	@Autowired
	UserController userController;

	@Test
	public void contextLoads() {
		Assertions.assertNotNull(userController);
	}

}
