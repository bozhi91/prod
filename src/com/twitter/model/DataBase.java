
package com.twitter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SET GLOBAL time_zone = '+3:00';

public class DataBase {
	private Connection connection;
	private Statement statement;

	public DataBase() throws Exception{	
		String user = "root";
		String pass = "root";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost/TEvent?user="+user+"&password="+pass);
		statement=connection.createStatement();			
	}

	//execute queries
	public ResultSet executeSQL(String query) throws SQLException{
		return statement.executeQuery(query);
	}
	
	//TODO: need to apply some validation here in order to avoid SQL injection.
	public void update(String query) throws SQLException{
		statement.executeUpdate(query);
	}
	
	public void disconnectBD() throws SQLException{ 
		statement.close();
		connection.close();
	}
}
