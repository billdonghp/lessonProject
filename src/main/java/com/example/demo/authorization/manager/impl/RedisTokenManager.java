package com.example.demo.authorization.manager.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.authorization.manager.TokenManager;
import com.example.demo.authorization.model.TokenModel;
import com.example.demo.utils.Constants;
@Component
public class RedisTokenManager implements TokenManager {
	private final StringRedisTemplate redis;
	@Autowired
	public RedisTokenManager(StringRedisTemplate redis) {
		this.redis = redis;
	}
	@Override
	public boolean checkToken(TokenModel model) {
		if(model == null) {
			return false;
		}
		//Redis取出Token
		String token = redis.boundValueOps(model.getUsername()).get();
		//决断取出的Token与传入Token是否相同
		if(token == null || !token.equals(model.getToken())) {
			return false;
		}
		//设置Redis中Token有效时间
		redis.boundValueOps(model.getUsername()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	@Override
	public TokenModel creatToken(String username) {
		String token = UUID.randomUUID().toString().replace("-","");
		TokenModel model = new TokenModel(username,token);
		//存储到Redis并设置过期时间
		redis.boundValueOps(username).set(token,Constants.TOKEN_EXPIRES_HOUR,TimeUnit.HOURS);
		return model;
	}

	@Override
	public void deleteToken(String username) {
		redis.delete(username);

	}

	@Override
	public TokenModel getToken(String authorization) {
		if(authorization == null || authorization.length() == 0) {
			return null;
		}
		String[] params = authorization.split("-");
		if(params.length != 2) {
			return null;
		}
		String username = params[0];
		String token = params[1];
		return new TokenModel(username,token);
	}
}
