package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,PageHelperAutoConfiguration.class})
//@MapperScan("com.example.demo.mapper")
public class LessonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonProjectApplication.class, args);
	}

}
