package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("费用封装类")
public class Cost {
	@ApiModelProperty(required= true,value="工资",example="工资", name="费用名称")
	private String name;

}
