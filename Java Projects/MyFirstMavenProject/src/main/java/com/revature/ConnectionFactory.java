package com.revature;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
	
public class ConnectionFactory {
	
	private static Connection connection;
	
	private ConnectionFactory() {
	
	}
	
	public static Connection getConnection(String connString) {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(connString);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return connection;
	
	}
}
