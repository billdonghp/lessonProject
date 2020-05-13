package com.example.demo.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseEntity {
	// @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="JDBC")
	private Long id;
	
	@Transient
    @ApiModelProperty(example = "1",required = true,name="page")
    private Integer page =1;

    @Transient
    @ApiModelProperty(example = "10",required = true,name="rows")
    @Value("${root.pageSize}")
    private Integer rows=10;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date createdat;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date updatedat;
}
