package com;

import com.app.demo1.Services.ExcelProcessService;
import com.app.demo1.Services.UserService;
import com.app.demo1.contoller.UserController;
import com.app.demo1.model.FileInfoModel;
import com.app.demo1.model.RecordModel;
import com.app.demo1.util.ArgumentCommandLine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = UserService.class)
@ComponentScan(basePackageClasses = ExcelProcessService.class)
@EnableJpaRepositories("com.app.demo1.jpa")


public class Demo1Application implements CommandLineRunner{

	private ExcelProcessService excelProcessService;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArgumentCommandLine argCommandLine = new ArgumentCommandLine();
		FileInfoModel fileInfoModel = argCommandLine.parseArgs(args);
		List<RecordModel> recModel = excelProcessService.processExcel(fileInfoModel);
	}
}
