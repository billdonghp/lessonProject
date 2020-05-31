package com.example.demo.exception;

import com.example.demo.entity.ResultEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2053902604387859889L;
	private Integer code;
	
	public CustomException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

}
