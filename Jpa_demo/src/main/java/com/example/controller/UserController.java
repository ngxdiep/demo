package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.User;
import com.example.service.ProductServiceIplm;
import com.example.service.UserServiceIplm;
import com.example.util.CustomErrorType;


@Controller
@RequestMapping("/api")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceIplm userService;
	@Autowired
	private ProductServiceIplm ProductSv;
	
	 @RequestMapping("/")
	  public String index() {
	    return "index";
	  }

	// -------------------Retrieve All Users---------------------------------------------
	 
	    @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<List<User>> listAllUsers() {
	        List<User> users = userService.findAllUsers();
	        if (users.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    }
	    // -------------------Retrieve Single User------------------------------------------
	    
	 // -------------------Retrieve Single User------------------------------------------
	    
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
	        logger.info("Fetching User with id {}", id);
	        User user = userService.findById(id);
	        if (user == null) {
	            logger.error("User with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	 
	    // -------------------Create a User-------------------------------------------
	 
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
	        logger.info("Creating User : {}", user);
	 
	        if (userService.isUserExist(user)) {
	            logger.error("Unable to create. A User with name {} already exist", user.getUserName());
	            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
	            user.getUserName() + " already exist."),HttpStatus.CONFLICT);
	        }
	        userService.saveUser(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getUserid()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	 
	    // ------------------- Update a User ------------------------------------------------
	 
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	        logger.info("Updating User with id {}", id);
	 
	        User currentUser = userService.findById(id);
	 
	        if (currentUser == null) {
	            logger.error("Unable to update. User with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setUserName(user.getUserName());
	        currentUser.setPhone(user.getPhone());
	        currentUser.setEmail(user.getEmail());
	 
	        userService.updateUser(currentUser);
	        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    }
	 
	    // ------------------- Delete a User-----------------------------------------
	 
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
	        logger.info("Fetching & Deleting User with id {}", id);
	 
	        User user = userService.findById(id);
	        if (user == null) {
	            logger.error("Unable to delete. User with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        userService.deleteUserById(id);
	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }
	 
	    // ------------------- Delete All Users-----------------------------
	 
	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteAllUsers() {
	        logger.info("Deleting All Users");
	 
	        userService.deleteAllUsers();
	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }
	
	@RequestMapping("/demo")
	public String index(Model model ){
		List<User> userlist = userService.findAllUsers();
		model.addAttribute("contacts",userlist);
		return "admin/datadata";
	}
	
	@RequestMapping("/update")
	public String update(Model model){
		User user = userService.findById(1);
		user.setEmail("0123456789");
		userService.updateUser(user);
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
		userService.saveUser(user);
		return "test";
	}

}
