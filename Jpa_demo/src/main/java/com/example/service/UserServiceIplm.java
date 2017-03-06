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
	private UserRepository userRepos;

	@Override
	public Iterable<User> findAll() {
		return userRepos.findAll();
	}

	@Override
	public List<User> search(String q) {
//		return userRepos.findByNameContaining(q);
		return  null;
	}

	@Override
	public User findOne(int id) {
		return userRepos.findOne(id);
	}

	@Override
	public void save(User contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
