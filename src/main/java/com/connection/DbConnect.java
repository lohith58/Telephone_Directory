package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","lohith");
		}catch(Exception e) {
			
		e.printStackTrace();
		
		}
		
		return con;
		
		
		
		
	}

}