package com;

import com.app.demo1.Services.DateServices;
import com.app.demo1.Services.UserService;
import com.app.demo1.contoller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = UserService.class)
@ComponentScan(basePackageClasses = DateServices.class)
@EnableJpaRepositories("com.app.demo1.jpa")
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
