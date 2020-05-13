package com.example.demo.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.authorization.interceptor.AuthorizationInterceptor;
import com.example.demo.authorization.resolvers.CurrentUserMethodArgumentResolver;
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	

	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	@Autowired
	private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizationInterceptor);
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(currentUserMethodArgumentResolver);
	}
}
