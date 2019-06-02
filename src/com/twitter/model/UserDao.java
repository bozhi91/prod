package com.twitter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.twitter.utils.Commons;
import com.twitter.beans.User;
import com.twitter.utils.DBConnections;

public class UserDao {
	
	public static User getUserByEmail(String email){
		
		User user = new User();
		
		try{
			Connection conn  = DBConnections.createConnection();
			Statement pst = conn.createStatement();
			ResultSet rs  = pst.executeQuery("SELECT * FROM users WHERE email='"+email+"'");

			String id = null;
			while(rs.next()){
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("name"));
				user.setBirthdate(rs.getString("birthdate"));
				user.setGender(rs.getString("sex").charAt(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return user;
	}
	
	public static boolean authenticateUser(String email, String password) {
		Commons comm=null;

		password = Commons.encryptPassword(password);
		try {
			Connection conn = DBConnections.createConnection();
			Statement pst   = conn.createStatement();
			ResultSet rs    = pst.executeQuery(
					"SELECT user_id FROM users WHERE email='" + email + "' AND password='" + password + "' ");

			String id = null;
			while (rs.next()) {
				id = rs.getString("user_id");
			}
			if (id != null) {				
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	//returns true if the user was created. False otherwise.
	public static boolean createUser(User user) {
		
		boolean insertStatus = true;
		
		try{			 						
			 DataBase db  = new DataBase();	//create connection with the DB  			 						 			 
			 
			 String query = "INSERT INTO users(email,name,password,phone,birthdate,sex) "
				 		+ "VALUES ('"+user.getEmail()+"', '"+user.getUsername()+"',"
				 		+ " '"+user.getPwd()+"', '"+user.getPhone()+"','"+user.getBirthdate()+"','"+user.getGender()+"')";
				 
			 
			 if(isUserUnique(user.getEmail())) {
				 db.update(query);  //Insert the user in the DB		
				 System.out.print("************The user was inserted *************");
				 insertStatus = true;
			 }
			 else {
				 System.out.print("************The user alrady exists in the database*************");
				 insertStatus = false;
			 }				 
			 db.disconnectBD(); //And finally  we disconnect from the database
			}
		catch (Exception e) {
			 e.printStackTrace();
		}			
		return insertStatus;
	}

	//returns TRUE if the user is unique. FALSE otherwise
	public static boolean isUserUnique(String email) {			 					
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
