package services;

import java.sql.SQLException;
import java.util.List;

import Service.ApplicationService;
import daos.EmployeeDAO;
import daos.ReimbursementDAO;
import models.Employee;
import models.Reimbursement;
import utils.ConnectionFactory;

public class driver {
	
	
	
	public static void main(String[] args) throws SQLException {
		List<Reimbursement> reimbursementList;
//	
//		
//	
//	ReimbursementDAO dao = new ReimbursementDAO(ConnectionFactory.getConnection());
//	reimbursementList = dao.getAll();
//	
//	//for (int i = 0; i < reimbursementList.size(); i++) {
//     //  System.out.println(reimbursementList.get(i).getDescription());
//    	
//	}
//		//System.out.println(dao.get(2).getAmount());
//	
//		
//		Reimbursement test = new Reimbursement(3, "money for nav",500.00, "APPROVED");
//		dao.createReimbursement(test, 3);
//	
	
		EmployeeDAO login = new EmployeeDAO();
		Employee bob = new Employee();
		bob = login.findUser("Brook1@gmail.com", "IamBrook123");
		System.out.println(bob.getPassword());
		
	}
	
		


		
}
