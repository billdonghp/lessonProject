package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@ConfigurationProperties(prefix = "limit")
@Getter
@Setter
public class LimitProperties {
	private String pageSize;
	
	private String description;

}
