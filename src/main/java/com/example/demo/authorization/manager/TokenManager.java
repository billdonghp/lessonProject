package com.example.demo.authorization.manager;

import com.example.demo.authorization.model.TokenModel;

public interface TokenManager {
	/**
	 * 检查Token是否有效
	 * @param model
	 * @return
	 */
	boolean checkToken(TokenModel model);
	/**
	 * 创建Token关联指定的用户
	 * @param username
	 * @return
	 */
	TokenModel creatToken(String username);
	/**
	 * 清除Token
	 * @param username
	 */
	void deleteToken(String username);
	/**
	 * 从字符串中解析Token
	 * @param authroization 加密的字符串
	 * @return
	 */
	TokenModel getToken(String authorization);

}
