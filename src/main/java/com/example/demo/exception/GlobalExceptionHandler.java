package com.example.demo.exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.Result;
import com.example.demo.utils.ResultUtil;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Result globalExceptionHandler(Exception e) {
		//@RequestBody
		if(e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
			return ResultUtil.error(-1,me.getBindingResult().getFieldError().getDefaultMessage());
		}
		if(e instanceof BindException) {
			BindException be = (BindException) e;
			
			return ResultUtil.error(-1,be.getFieldError().getDefaultMessage());
		}
		if(e instanceof CustomException) {
			CustomException ce = (CustomException) e;
			return ResultUtil.error(ce.getCode(),ce.getMessage());
		}	
		return ResultUtil.error(-1, "未知错误");
	}
}
