package com.twitter.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

public class Commons {

	public static String encryptPassword(String password) {
		
		String encrypted = "";
		//Encrypt the password as MD5
		 try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

		        StringBuilder sb = new StringBuilder();
		        for (byte b : hashInBytes) {
		            sb.append(String.format("%02x", b));
		        }
		        encrypted = sb.toString();		       		        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}			
		return encrypted;
	}
	
}
