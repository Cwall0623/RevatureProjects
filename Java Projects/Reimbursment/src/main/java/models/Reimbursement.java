package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "reinbursement")
public class Reimbursement {
	public Reimbursement(double amount, String description, String status, Employee crewMember) {
		super();
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.crewMember = crewMember;
	}
	@Column(name = "balance")
	double amount;
	@Id
	@Column(name = "case_number")
	int caseNumber;
	@Column(name = "description")
	String description;
	@Column(name = "status")
	String status;
	
	@ManyToOne
	private Employee crewMember;
	
	public Reimbursement(String status) {
		super();
		this.status = status;
	}

	public Reimbursement(String status, Employee crewMember) {
		super();
		this.status = status;
		this.crewMember = crewMember;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int caseNumber, String description, double amount, String status) {
		super();
		this.amount = amount;
		this.caseNumber = caseNumber;
		this.description = description;
		this.status = status;
	}
	public Reimbursement(double amount, int caseNumber, String description, String status, Employee crewMember) {
		super();
		this.amount = amount;
		this.caseNumber = caseNumber;
		this.description = description;
		this.status = status;
		this.crewMember = crewMember;
	}

	public Reimbursement(int caseNumber, String status) {
		super();
		this.caseNumber = caseNumber;
		this.status = status;
	}

	public Employee getCrewMember() {
		return crewMember;
	}

	public void setCrewMember(Employee crewMember) {
		this.crewMember = crewMember;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(int caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
