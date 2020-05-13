package com.example.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@ConfigurationProperties(prefix = "limit")
@Getter
@Setter
public class LimitComponent {
	private String pageSize;
	
	private String description;

}
