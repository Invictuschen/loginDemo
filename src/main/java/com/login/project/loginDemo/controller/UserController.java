package com.login.project.loginDemo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.project.loginDemo.domain.User;
import com.login.project.loginDemo.service.UserService;


@RestController
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@PostMapping("/login") 
	public String verifyLogin(String username, String password) {
		 User user = new User();
	        user.setUserName(username);
	        user.setPassword(password);
	        boolean verify = userService.verifyLogin(user);
	        if (verify) {
	            return "success";
	        } else {
	            return "redirect:/login";
	        }
	}
	
	@PostMapping("/signin")
	public String singIn(@RequestBody User user) {
		System.out.println("Come in%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		if (user == null) {
			return "Register failed";
		} else {
			userService.signIn(user);
			return "Register successfully";
		}
	}
	@GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
	
}
