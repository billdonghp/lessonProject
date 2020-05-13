package com.example.demo.configuration;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@Bean(name = "mysql")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource businessDbDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "oracle")
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource newhomeDbDataSource() {
	    return DataSourceBuilder.create().build();
	}	
}
