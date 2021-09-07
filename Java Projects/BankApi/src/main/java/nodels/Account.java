package nodels;

import java.util.Map;

public class Account {
	

		private int accountId;
	
		private double AccountBalance;
		
		
		public Account() {
			super();
		}
		
		public Account(int accountId, double AccountBalance) {
			super();
			this.accountId = accountId;
			this.AccountBalance = AccountBalance;
		}
		
		
		
		
		
		
		
		
		
		
		
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public double getAccountBalance() {
			return AccountBalance;
		}
		public void setAccountBalance(double AccountBalance) {
			this.AccountBalance = AccountBalance;
		}
		

		public static void createAccountId() {
			
		}
		
		public static void depositMoney() {
			
		}
		
		public static void withdrawMoney() {
			
		}

		public static void transferMoney() {
			
		}
	}

