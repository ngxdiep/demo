package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService  {
	User findById(int id);
	 
    User findByName(String name);
 
    void saveUser(User user);
 
    void updateUser(User user);
 
    void deleteUserById(int id);
 
    void deleteAllUsers();
 
    List<User> findAllUsers();
 
    boolean isUserExist(User user);

}
