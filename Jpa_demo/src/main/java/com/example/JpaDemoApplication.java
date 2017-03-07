package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceIplm;

@SpringBootApplication
public class JpaDemoApplication {
 
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(JpaDemoApplication.class, args);
		
	}
	
}
