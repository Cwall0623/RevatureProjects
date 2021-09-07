package nodels;

import java.util.Random;

public class Bank {
	public static void createNewCustomer( String firstName, String lastName, int accountId) {
		
	}
	
	public static int createCustomerId() {
		Random rand = new Random();
		Random AccountId = new Random();
		int upperbound = 11;
		int int_random = rand.nextInt(upperbound);
		return int_random;
	}
	
	public static  int createAccountId() {
		Random rand = new Random();
		Random AccountId = new Random();
		int upperbound = 11;
		int int_random = rand.nextInt(upperbound);
		return int_random;
	}
}
