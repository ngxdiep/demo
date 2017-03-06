package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.UserServiceIplm;


@Controller
public class UserController {
	
	@Autowired
	private UserServiceIplm UserSv;
	
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

}
