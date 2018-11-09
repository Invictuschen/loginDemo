package com.login.project.loginDemo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.login.project.loginDemo.dao.UserDao;
import com.login.project.loginDemo.domain.User;
import com.login.project.loginDemo.service.UserService;

@Service
@Transactional
public class LoginServiceImpl implements UserService {

	@Autowired
	UserDao userDAO;
	
	
	@Override
	public boolean verifyLogin(User user) {

	     List<User> userList = userDAO.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	      return userList.size()>0;
	  }


//	@Override
//	public boolean verifySignIn(String username) {
//		// TODO Auto-generated method stub
//		if (userDAO.findByUserName(username) != null) {
//			return false;
//		}
//		return true;
//	}


	@Override
	public User signIn(User newUser) {
		// TODO Auto-generated method stub
		System.out.println(newUser.getUserName());
		List<User> userList = userDAO.findByUserName(newUser.getUserName());
		for(User uu : userList) {
			System.out.println(uu.getId());
			System.out.println(uu.getUserName());
		}
		System.out.println("Size :"+userList.size());
		if (userList == null || userList.size() == 0) {
			User user = new User();
			user.setUserName(newUser.getUserName());
			user.setPassword(newUser.getPassword());
			//....
			
			return userDAO.save(user);
		} else {
			return null;
		}
	}
	
	
	
	
	
}
