package com.example.demo.mapper.mysql;

import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Customer;

import tk.mybatis.mapper.common.Mapper;

public interface CustomerMapper extends Mapper<Customer> {
	
	@Select("select * from customer where name = #{name}")
	Customer selecCustomer(Customer customer);

}
