package com.twitter.beans;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import com.twitter.utils.Commons;

public class User implements java.io.Serializable   {
	
	private static final long serialVersionUID = 1L;

	private String username  = "";
	private String email     = "";
	private String phone     = "";
	private String pwd 	 	 = "";
	private String repwd 	 = "";
	private String birthdate = "";
	private char gender;
	//private InputStream image;
	
	public static void main() {}
	
	
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepwd() {
		return this.repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getPwd() {
		return this.pwd;
	}
	public void setPwd(String pwd) {		
		this.pwd = Commons.encryptPassword(pwd);
	}
	
	public String getBirthdate() {
		return this.birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate=birthdate;
	}
	
	public char getGender() {
		return this.gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	//--------Validate the input from the frontend-----------
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
	public boolean isComplete() {
		return true;
		//return(hasValue(getUsername()) &&
			  // hasValue(getPhone()) &&
			//   hasValue(getMail()) &&
			  // error[0] ==0);
	
	}
}
