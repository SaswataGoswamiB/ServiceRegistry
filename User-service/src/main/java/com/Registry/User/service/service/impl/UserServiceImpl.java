package com.Registry.User.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registry.User.service.Exception.ResourceNotFoundException;
import com.Registry.User.service.Repo.UserReposiotory;
import com.Registry.User.service.entities.User;
import com.Registry.User.service.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserReposiotory userepoReposiotory;

	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
	return 	userepoReposiotory.save(user);
	}

	@Override
	public List<User> getallUserList() {
		// TODO Auto-generated method stub
		return userepoReposiotory.findAll();
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return userepoReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found User !!!!"));
	}

}
