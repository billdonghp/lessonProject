package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Result;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("customer/")
public class CustomerController {
	@Autowired
	private CustomerService cs;
	@Value("${limit.pageSize}")
	private int pageSize;
	@GetMapping("query")
	public Result query() {
		PageHelper.startPage(1,pageSize);
		return ResultUtil.ok(cs.query());
	}
	@GetMapping("queryPage")
	public PageInfo<Customer> queryPage(Customer cu) {
		return new PageInfo<Customer>(cs.queryPage(cu));
	}
	
	@GetMapping("sel")
	public Result sel(){
		Customer cu = new Customer();
		cu.setName("孙松");
		return ResultUtil.error(-1, "error");
	}
	@PostMapping("credit")
	public Result credit(Customer cu) {
		cu.setCreatedat(new Date());
		cu.setUpdatedat(new Date());
		if(cs.save(cu) == 1) {
			return ResultUtil.ok();
		}
		return ResultUtil.error(-1, "error");
		
	}

}
