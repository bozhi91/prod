package models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.mysql.cj.xdevapi.Statement;
import com.sun.corba.se.pept.transport.Connection;


public class User implements java.io.Serializable   {

	private static final long serialVersionUID = 1L;

	private String username  = "";
	private String mail  = "";
	private String pwd 	 = "";
	private String repwd 	 = "";
	private String phone = "";
	private String birthdate = "";
	private char gender;
	
	private Pattern pwdpattern = Pattern.compile("^(?=.*[0-9])(?=.*?[A-Z])(?=.*?[a-z]).{5,}$");
	
	/*  Control flag, shows the parameters that have been correctly filled */
	private int[] error = {0,0,0}; 
	
	public static void main() {}

	public char getGender() {
		return this.gender;
	}
	public void setGender(char gender) {
		
		//if(gender==null) -> get the imput from the <form>
		//this.gender = 'N';
		/*
		 * M-Male
		 * F-Female
		 * N-Undefined
		 * 
		 * */
		
		System.out.print("Gender: "+gender);
		this.gender = gender;
	}
	
	
	public String getRepwd() {
		return this.repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	public String getBirthdate() {
		return this.birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate=birthdate;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public int[] getError() {
		return error;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	public void setMail(String mail) {		
		//Before setting the user email, we first check if that email exists in our DB.
		//If so, we set the error message to 1 and return the error message to the RegisterView
		if(!this.isUserUnique(mail)){
			error[0] = 1;
		}
		this.mail = mail;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	//No validation is needed. The password is validated at the frontend/client-side
	public void setPwd(String pwd) {		
		this.pwd = pwd;
		
		//Encrypt the password as MD5
		 try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] hashInBytes = md.digest(this.pwd.getBytes(StandardCharsets.UTF_8));

		        StringBuilder sb = new StringBuilder();
		        for (byte b : hashInBytes) {
		            sb.append(String.format("%02x", b));
		        }
		        this.pwd = sb.toString();		       		        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public void insertUser(){				 
		try{			 			
			 DataBase db  = new DataBase();	//create connection with the DB  			 						 
			 String query 
			 = "INSERT INTO users(email,name,password,phone,birthdate,sex) "
			 		+ "VALUES ('"+this.mail+"', '"+this.username+"', '"+this.pwd+"', '"+this.phone+"','"+this.birthdate+"','"+this.gender+"')";
			 
			 db.update(query);  //Insert the user in the DB			 
			 db.disconnectBD(); //And finally  we disconnect from the database
			}
		catch (Exception e) {
			 e.printStackTrace();
		}			
	}
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete() {
		return(hasValue(getUsername()) &&
			   hasValue(getPhone()) &&
			   hasValue(getMail()) &&
			   error[0] ==0);
		
		//return true;
		/*
	    return(hasValue(getUsr()) &&
	    	   hasValue(getMail()) &&
	    	   hasValue(getPhone()) &&
	           hasValue(getPwd()) );*/
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
	//returns TRUE if the user is unique. FALSE otherwise
	public boolean isUserUnique(String email) {
		 
		System.out.print("email: "+email);
		
		int rows=0;
		try { 			   			  			  
			 //Connect to the Database			
			 DataBase db  = new DataBase();	  
			 ResultSet rs = db.executeSQL("select * from users where email like '"+email+"'");//Execute the query				
		
			 //Count the number of rows returned by the query.
			 //If the email is not stored yet in the DB, that number must be 0.
			 while(rs.next()){			 
				 rows++;			
			 }										
			 db.disconnectBD(); //And finally  we disconnect from the database
			}catch (Exception e) {
			 e.printStackTrace();
			}	
		
			//User is unique
		    if(rows==0){
				return true;
			}
		return false;//user with that email already exists
	}
}
