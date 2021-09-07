 package nodels;

import java.util.ArrayList;
import java.util.Objects;



public class Customer {
	private int customerId;
	public String name;
	public int accountId;
	public int junctionId;
	
	
	
	public int getJunctionId() {
		return junctionId;
	}

	public void setJunctionId(int junctionId) {
		this.junctionId = junctionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Customer() {
		super();
	}
	
	public void setName(String Name) {
		this.name = Name;
	}
	
	public String getName() {
		return name;
	}

	
	public Customer(String name, int clientId) {
		
		this.customerId = customerId;
			
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}

	
	


	

