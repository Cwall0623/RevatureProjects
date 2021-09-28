package Service;

import java.sql.SQLException;
import java.util.List;

import daos.EmployeeDAO;
import daos.ReimbursementDAO;
import models.Reimbursement;

public class ApplicationService {
	private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	
	public Reimbursement getReimbursement(int caseNumber) throws SQLException{
		return this.reimbursementDAO.get(caseNumber);
	}

	public List<Reimbursement> getCrewMemeberReimbursements(int crewMember) throws SQLException{
		List<Reimbursement> TempList = null;
		List<Reimbursement> hibernateList = reimbursementDAO.findByCrewNumber(crewMember);
		Reimbursement tempReimbursement = new Reimbursement();
		
		for(int i = 0; i <hibernateList.size(); i++) {
			//System.out.println(hibernateList.get(i).getCaseNumber());
		
			tempReimbursement = null;
			tempReimbursement.setCaseNumber(hibernateList.get(i).getCaseNumber());
			tempReimbursement.setAmount(hibernateList.get(i).getAmount());
			tempReimbursement.setDescription(hibernateList.get(i).getDescription());
			tempReimbursement.setStatus(hibernateList.get(i).getStatus());
		
			TempList.add(tempReimbursement);
		}
		
		
		return TempList;
		
	}
}
