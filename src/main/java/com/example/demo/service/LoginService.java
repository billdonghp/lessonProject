package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ResultEnum;
import com.example.demo.exception.CustomException;

@Service
public class LoginService {
	public void login(String username, String pwd) throws Exception{
		if(!("20120262".equals(username))) {
			throw new CustomException(ResultEnum.USER_NOTFOUND);
		}
		if(!("123".contentEquals(pwd))) {
			throw new CustomException(ResultEnum.USERNAME_OR_PASSWORD);
		}
		throw new CustomException(ResultEnum.SUCCESS);
	}
}
