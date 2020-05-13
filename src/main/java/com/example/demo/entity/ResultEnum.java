package com.example.demo.entity;

public enum ResultEnum {
	SUCCESS(200,"Success"),
	USERNAME_OR_PASSWORD(1000,"用户名密码错误"),
	USER_NOTFOUND(1001,"用户不存在"),
	USER_NOTLOGIN(1002,"用户未登陆");
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getMsg() {
		return this.msg;
	}

}
