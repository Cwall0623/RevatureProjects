package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nodels.Account;
import nodels.Customer;


public class CustomerDAO implements Dao<Customer> {

	private List<Customer> customersTable;
	Connection connection;
	
	 public CustomerDAO(Connection conn) {
	        customersTable = new ArrayList<>();
	        connection = conn;
	 }
	
	
	@Override
	public Customer get(int id) throws SQLException {
		 String sql = "Select * FROM customers WHERE customer_id = ? LIMIT 1";
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, id);

	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	            Customer row = new Customer();
	            row.setCustomerId(rs.getInt("customer_id"));
	            System.out.println("name of client " + rs.getString("name"));
	            row.setName(rs.getString("name"));
	            
	            return row;
	        } else {
		return null;
	        }
	}


	
	@Override
	public List<Customer> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customers";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Customer row = new Customer();
			row.setName(rs.getString("name"));
			row.setCustomerId(rs.getInt("customer_id"));
			customersTable.add(row);
			
		}
			return customersTable;
	}

	@Override
	public void save(Customer customer) throws SQLException {
	String sql = "INSERT INTO accounts_customers (customer_id,account_id) VALUES (?,?)";

		PreparedStatement pstmt = connection.prepareStatement(sql);
	
		pstmt.setInt(1, customer.getCustomerId());
		pstmt.setInt(2, customer.getAccountId());
		
		String sql2 = "INSERT INTO customers (name,customer_id) VALUES (?,?)";

		PreparedStatement pstmt2 = connection.prepareStatement(sql2);
		pstmt2.setString(1, customer.getName());
		pstmt2.setInt(2, customer.getCustomerId());
		
		String sql3 = "INSERT INTO accounts (account_id,balance) VALUES (?,?)";
		PreparedStatement pstmt3 = connection.prepareStatement(sql3);
		pstmt3.setInt(1, customer.getAccountId());
		pstmt3.setDouble(2, customer.getAccountBalance());
		
		if(pstmt.executeUpdate() > 0 && pstmt2.executeUpdate() > 0 && pstmt3.executeUpdate()> 0) {
			 pstmt.getResultSet();
			 pstmt2.getResultSet();
			 pstmt3.getResultSet();
		}
		
	}

	@Override
	public void update(Customer customer, String[] params) {
		
		
	}

	@Override
	public void delete(Customer t) {
		
		
	}

}
