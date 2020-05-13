package com.example.demo.authorization.model;

import com.example.demo.utils.JasyptUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenModel {
	//用户名
	private String username;
	//随机生成UUID
	private String token;
	
	@Override
	public String toString() {
		return JasyptUtil.encode(username + "-" + token);
	}
}
