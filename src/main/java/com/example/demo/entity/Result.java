package com.example.demo.entity;

import lombok.*;

@Data
public class Result<T> {
	private Integer code;
	private String msg;
	private T data;
}
