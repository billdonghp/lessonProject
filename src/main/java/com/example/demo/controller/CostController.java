package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cost;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="cost/")
@Api(tags="1.费用")
public class CostController {
	
	@GetMapping(value ="query")
	@ApiOperation("费用查询")
	public  Cost get() {
		Cost c = new Cost();
		
		c.setName("bb");
		return c;
		
	}
	
	@GetMapping(value = "set/{name}")
	@ApiOperation("费用修改")
	public Cost set(@PathVariable String name) {
		Cost c = new Cost();
		c.setName(name);
		return c;
	}
	
	@PostMapping(value="save")
	@ApiOperation("费用保存")
	@ApiImplicitParams({
		@ApiImplicitParam(name="auth", value="auth",required=true,paramType="header")
	})
	public int save(@RequestBody @ApiParam(name="费用申请对象",value="传入json格式",required=true) Cost cost) {
		
		System.out.println(cost.getName());
		return 1;
	}

}
