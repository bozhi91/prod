package com.twitter.beans;

public class BeanLogin {

	private String email    = "";
	private String password = "";
	
	private int[] error = {0};
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	
	public int[] getError() {
		return error;
	}
	
	public boolean isComplete() {
	    return(hasValue(getEmail()) && hasValue(getPassword()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
}
