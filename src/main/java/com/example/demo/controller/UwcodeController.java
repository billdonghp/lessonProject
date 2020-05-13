package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Uwcode;
import com.example.demo.service.UwcodeService;

@RestController
@RequestMapping("uwcode/")
public class UwcodeController {
	@Autowired
	private UwcodeService us;
	@GetMapping("get")
	public List<Uwcode> get(){
		return us.get();
	}

}
