package com.example.demo.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptUtil {
	private static String PASSWORD = "1234567890abcdef";
	public static String encode(String str) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(PASSWORD);
		return encryptor.encrypt(str);
	}
	public static String decode(String str) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(PASSWORD);
		return encryptor.decrypt(str);
	}
}
