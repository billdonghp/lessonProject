package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.LimitComponent;

@Controller
public class PropertiesController {
	@Autowired
	private LimitComponent lc;
	@RequestMapping(value="val/{name}",method=RequestMethod.GET)
	@ResponseBody
	
	public String val(@RequestParam(value="id",required=false,defaultValue="100") String id,@PathVariable String name) {
		return "Size: " + lc.getPageSize() + "说明:" + lc.getDescription() + "id" + id + name;
	}
}
