package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/[database_name]";
	private  static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	public DatabaseUtil() {
		try {
			Class.forName(DRIVER_PATH);
		}
		catch(Exception e) {
			throw new RuntimeException("SOmething went wrong");
		}
		
	} // End of Constructor


	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	} // End of Connection

}
