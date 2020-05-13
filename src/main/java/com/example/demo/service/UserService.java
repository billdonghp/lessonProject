package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.mysql.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper um;
	
	public User selUser(String username) {
		return um.selecUser(username);
	}
}
