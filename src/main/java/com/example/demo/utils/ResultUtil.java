package com.example.demo.utils;

import com.example.demo.entity.Result;
import com.example.demo.entity.ResultEnum;
import com.sun.org.apache.xpath.internal.objects.XNull;

public class ResultUtil {
	public static Result ok(Object obj){
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMsg());
		result.setData(obj);
		return result;
	}
	
	public static Result ok() {
		return ok();
	}
	
	public static Result error(Integer code,String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
