package BankingApp;

public class Driver {
	
	public static void main(String[] args) {
		Bank CapitalOne = new Bank();
		
		System.out.println();
		Client tim = new Client("Tim", "Doe", 1);
		Client Thomas = new Client("Thomas", "Doe", 2);
		
		Account timAccount = new Account(55, 400.0);
		Account thomasAccount = new Account(44, 1000.0);
		timAccount.transferMoney(timAccount, thomasAccount, 100);
		timAccount.withdrawMoney(100, timAccount);
		
		System.out.println("Client Balance" + thomasAccount.checkBalance(thomasAccount));
		System.out.println("Client Balance" + timAccount.checkBalance(timAccount));
		
		
	}
}