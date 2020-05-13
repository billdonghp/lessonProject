package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Uwcode;
import com.example.demo.mapper.oracle.UwcodeMapper;
import com.github.pagehelper.PageHelper;

@Service
public class UwcodeService {
	@Autowired
	private UwcodeMapper uwcodeMapper;
	
	public List<Uwcode> get(){
		PageHelper.startPage(1, 5);
		return uwcodeMapper.selectAll();
	}

}
