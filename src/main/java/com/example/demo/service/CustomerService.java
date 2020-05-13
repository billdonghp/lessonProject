package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.mysql.CustomerMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	public Page<Customer> query() {
		return (Page<Customer>)customerMapper.selectAll();
	}
	
	public List<Customer> queryPage(Customer cu) {
		if(cu.getPage() != null && cu.getRows() !=null) {
			PageHelper.startPage(cu.getPage(), cu.getRows());
		}
		return customerMapper.selectAll();
	}
	public Customer selCustomer(Customer cu) {
		return customerMapper.selecCustomer(cu);
	}
	
	public int save(Customer cu) {
		return customerMapper.insertSelective(cu);
	}

}
