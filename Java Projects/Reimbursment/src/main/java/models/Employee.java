package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "crew_number")
	int crewNumber;
	@Column(name ="crew_email")
	String crewEmail;
	@Column(name = "password")
	private String Password;
	@Column(name = "isManager")
	String isManager;
	public int getCrewNumber() {
		return crewNumber;
	}
	
	public Employee() {
		super();
	}
	
	
	
	
	public Employee(int crewNumber) {
		super();
		this.crewNumber = crewNumber;
	}

	public Employee(int crewNumber, String crewEmail, String password, String isManager) {
		super();
		this.crewNumber = crewNumber;
		this.crewEmail = crewEmail;
		Password = password;
		this.isManager = isManager;
	}
	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}
	public String getCrewEmail() {
		return crewEmail;
	}
	public void setCrewEmail(String crewEmail) {
		this.crewEmail = crewEmail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String isManager() {
		return isManager;
	}
	public void setManager(String isManager) {
		this.isManager = isManager;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}
}
