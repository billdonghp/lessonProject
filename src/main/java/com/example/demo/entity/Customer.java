package com.example.demo.entity;

import javax.persistence.Table;

import lombok.Data;

//@Table指定该实体类对应的表名,如表名为customer,类名为Customer可以不需要此注解
@Table(name="customer")
@Data
public class Customer extends BaseEntity {
	private String name;

    private String mobilephone;

    private String address;

    private String remark;

    private Integer status;

}
