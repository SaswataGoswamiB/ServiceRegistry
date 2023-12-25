package com.Registry.User.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return null;
	}

	@Override
	public List<User> getallUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
