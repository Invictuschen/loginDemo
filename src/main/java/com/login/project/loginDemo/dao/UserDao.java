package com.login.project.loginDemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.project.loginDemo.domain.User;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	public List<User> findByUserNameAndPassword(String username, String password);
	
	public List<User> findByUserName(String username);

}
