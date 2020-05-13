package com.example.demo.mapper.mysql;

import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	@Select("select * from user where username = #{username}")
	User selecUser(String username);

}
