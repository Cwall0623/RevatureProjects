package com.revature;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EntryPoint {
	public static void main(String[] args) {
		 Connection conn = ConnectionFactory.getConnection("jdbc:mariadb://database-1.cp4wuutllarp.us-east-2.rds.amazonaws.com:3306/demo?user=admin&password=Bellavanilla1!");
		//"jdbc:mariadb://<RDS END POUNT FROM AWS RDS SERVICE>:<port>/<DATABASE NAME>?USER=<USER NAME>&password=<PASSWORD>
	
		String sql = "SELECT * FROM test_table";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				System.out.println("string_id: ["
                        + rs.getInt("string_id")
                        + "]   string: ["
                        + rs.getString("string")
                        + "]");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
