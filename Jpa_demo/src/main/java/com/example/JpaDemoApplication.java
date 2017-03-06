package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.UserServiceIplm;

@SpringBootApplication
public class JpaDemoApplication {
 

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
}
