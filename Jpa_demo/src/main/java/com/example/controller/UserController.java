package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.ProductServiceIplm;
import com.example.service.UserServiceIplm;


@Controller
public class UserController {
	
	@Autowired
	private UserServiceIplm UserSv;
	@Autowired
	private ProductServiceIplm ProductSv;
	
	 @RequestMapping("/")
	  public String index() {
	    return "index";
	  }

	
	@RequestMapping("/demo")
	public String index(Model model ){
		List<User> userlist = UserSv.findAllUsers();
		model.addAttribute("contacts",userlist);
		return "admin/datadata";
	}
	
	@RequestMapping("/update")
	public String update(Model model){
		User user = UserSv.findById(1);
		user.setEmail("0123456789");
		UserSv.updateUser(user);
		model.addAttribute("user",user);
		return "data";
	}
	@RequestMapping("/test")
	public String test(Model model){
		//UserSv.deleteUserById(3);
		User user =new User();
		user.setUserName("12312312");
		user.setPassword("123123");
		user.setEmail("12312312");
		user.setPhone("123123");
		UserSv.saveUser(user);
		return "test";
	}

}
