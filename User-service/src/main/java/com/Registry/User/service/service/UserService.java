package com.Registry.User.service.service;

import java.util.List;

import com.Registry.User.service.entities.User;

public interface UserService {
	
	//User Operations.
	
	User saveuser(User user);
	
	List<User> getallUserList();
	
	User getUser(Integer id);
}
