package com.example.demo.authorization.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.example.demo.authorization.annotation.CurrentUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Constants;
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
	@Autowired
	private UserService us;
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(CurrentUser.class) ) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String username =(String)webRequest.getAttribute(Constants.CURRENT_USER_NAME, RequestAttributes.SCOPE_REQUEST);
		if(username !=null) {
			return us.selUser(username);
		}
		throw new MissingServletRequestPartException(Constants.CURRENT_USER_NAME);
	}
}
