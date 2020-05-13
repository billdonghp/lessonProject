package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.authorization.annotation.Authorization;
import com.example.demo.authorization.annotation.CurrentUser;
import com.example.demo.authorization.manager.TokenManager;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.utils.ResultUtil;


@RestController
public class LoginController {
	@Autowired
	private TokenManager rtm;
	
	@GetMapping("login/{username}")
	public Result login(@PathVariable("username") String username) {
		return ResultUtil.ok(rtm.creatToken(username).toString());
	}
	
	@Authorization
	@PostMapping("check")
	public Result check(@CurrentUser User user){
		//ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		//return ResultUtil.ok(sra.getRequest().getAttribute("CURRENT_USER_NAME").toString());
		
		return ResultUtil.ok(user);
	}
}
