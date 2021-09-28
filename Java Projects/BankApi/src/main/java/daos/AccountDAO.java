package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import nodels.Account;

public class AccountDAO implements Dao<Account>{
	private List<Account> accounts;
	Connection connection;
	
	public AccountDAO(Connection conn) {
		accounts = new LinkedList<>();
		connection = conn;
	}
	
	
	
	public List<Account> customerAccounts(int customerid) throws SQLException {
		String sql = "SELECT a.account_id, a.balance FROM customers c JOIN accounts_customers ac ON c.customer_id = ac.customer_id JOIN accounts a ON ac.account_id = a.account_id WHERE c.customer_id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, customerid);
		ResultSet rs = pstmt.executeQuery();
		ResultSet rs2 = pstmt.executeQuery();

		
		while(rs.next() && rs2.next()) {
			Account row = new Account();
				row.setAccountId(rs.getInt("account_id"));
				row.setAccountBalance(rs2.getDouble("balance"));
				accounts.add(row);
				
		}
		return accounts;
		
	}
	
	
	public Account getAccount(int accountid) throws SQLException {
		String sql = "SELECT * FROM accounts a WHERE account_id LIKE ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, accountid);
		ResultSet rs = pstmt.executeQuery();
		Account row = new Account();
		if(rs.next()) {
			row.setAccountId(rs.getInt("account_id"));
			row.setAccountBalance(rs.getDouble("balance"));
			return row;
		}else {
			return null;
		}
		
		
		
	}

	
	
	@Override
	public Account get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Account account) throws SQLException {
		
		
	}
		
	

	@Override
	public void update(Account t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}

	
}
