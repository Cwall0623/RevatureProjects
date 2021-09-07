package BankingApp;

import java.util.ArrayList;
import java.util.Objects;

public class Client {
	private String firstName;
	private String lastname;
	private int clientId;
	ArrayList<Account> accountlist = new ArrayList<Account>();
	
	
	public Client(){
		super();
	}
	

	public ArrayList<Account> getAccountlist() {
		return accountlist;
	}


	public void setAccountlist(ArrayList<Account> accountlist) {
		this.accountlist = accountlist;
	}


	public Client(String fname, String lname){
		this.firstName = fname;
		this.lastname = lname;
	}
	
	public Client(String fname, String lname, int clientId) {
		this(fname,lname);
		this.clientId = clientId;
			
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	
	}
	
	public static int accountIdList() {
		return 0;
	}
	
	
	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastname=" + lastname + ", clientId=" + clientId + "]";

	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, firstName, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return clientId == other.clientId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastname, other.lastname);
	}
}