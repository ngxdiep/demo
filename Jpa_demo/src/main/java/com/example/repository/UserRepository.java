package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	//List<User> findByNameContaining(String username);
}
