package com.login.project.loginDemo.service;

import com.login.project.loginDemo.domain.User;

public interface UserService {

	public boolean verifyLogin(User user);
	
//	public boolean verifySignIn(String username);
	
	public User signIn(User newUser);
}
