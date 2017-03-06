package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.UserService;
import com.example.service.UserServiceIplm;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
		
		UserServiceIplm Usersv = new UserServiceIplm() ;
		
		System.out.print(Usersv.findAll());
		System.out.println("asdasdasdasdas");
	}
}
