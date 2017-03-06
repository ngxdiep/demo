package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService  {
	Iterable<User> findAll();

    List<User> search(String q);

    User findOne(int id);

    void save(User contact);

    void delete(int id);

}