package com.twitter.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
//SET GLOBAL time_zone = '+3:00';
public class DBConnections {
	private final static Logger LOG = Logger.getLogger(DBConnections.class.getName());
	public static String URL_BDD = "jdbc:mysql://localhost:3306/TEvent";
	public static String USERNAME = "root";
	public static String PASSWORD = "root";
	public static Connection createConnection() {
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL_BDD, PASSWORD, PASSWORD); // loading mysql driver
			LOG.log(Level.INFO, "Connection with BDD established");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return conn;
	}
}
