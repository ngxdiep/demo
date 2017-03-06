package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.service.UserServiceIplm;


@Controller
public class UserController {
	
	@Autowired
	private UserServiceIplm UserSv;
	
	 @RequestMapping("/")
	  @ResponseBody
	  public String index() {
	    return "Hello World!!!";
	  }

	
	@RequestMapping("/demo")
	@ResponseBody
//	@GetMapping("/demo")
	public String index(Model model ){
		model.addAttribute("contacts", UserSv.findAll());
		return "index";
	}

}
