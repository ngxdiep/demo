package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceIplm implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByName(String name) {
		//return userRepository.findByName(name);
		return null;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		saveUser(user);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		 return findByName(user.getUserName()) != null;
	}
	
	
}
