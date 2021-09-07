package BankingApp;

import java.util.Map;

public class Account {

	private int accountId;
	private int amount;
	private Map<Integer, Integer> getAmountInformation;
	public double accountBalance;
	
	
	public Account(){
		super();
	}
	
	public Account(int accountId, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Map<Integer, Integer> getGetAmountInformation() {
		return getAmountInformation;
	}
	public void setGetAmountInformation(Map<Integer, Integer> getAmountInformation) {
		this.getAmountInformation = getAmountInformation;
	}

	public static void createAccountId() {
		
	}
	
	public void depositMoney(double money, Account One) {
		One.accountBalance = One.accountBalance + money;
	}
	
	public  void withdrawMoney(double money, Account One) {
		One.accountBalance = One.accountBalance - money;
	}

	public  void transferMoney(Account One , Account Two, double transferMoney) {
		One.accountBalance = One.accountBalance - transferMoney;
		Two.accountBalance = transferMoney + Two.accountBalance;
		
	}
	public double checkBalance(Account One) {
		return One.accountBalance;
	}
}

