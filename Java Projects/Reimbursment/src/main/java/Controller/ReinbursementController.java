package Controller;

import java.sql.SQLException;
import java.util.List;

import Service.ApplicationService;
import daos.ReimbursementDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Employee;
import models.Reimbursement;
import utils.ConnectionFactory;

public class ReinbursementController{
	private static Javalin javalin;
	 	static ApplicationService service = new ApplicationService();
	 	
	 	static EmployeeController employee = new EmployeeController();
	public static void init(Javalin app) {
	 javalin = app;
	        javalin.get("/getAll", ReinbursementController::getAll);
	        javalin.get("/test", ReinbursementController::testReimbursementController);
	        javalin.post("/createReimbursement", ReinbursementController::createReimbursement);
	        javalin.get("/findByCrewNumber",ReinbursementController::findByCrewNumber);
	        javalin.post("/update", ReinbursementController::update);
	        javalin.get("/getAllJDBC", ReinbursementController::getCrewReimbursements);
	}
	 		public static void testReimbursementController(Context ctx) {
	 			ctx.status(200);
	 			ctx.result("Reimbursement test Recieved");
	 			
	 		}
	 
	 
	 		public static void getAll(Context ctx) throws SQLException {
	    	ReimbursementDAO dao = new ReimbursementDAO();
	    	List<Reimbursement> reimbursements = dao.findAll();
	    	ctx.json(reimbursements);
	 		}
	 		
	 		
	 		public static void findByCrewNumber(Context ctx) throws SQLException{
		 	List<Reimbursement> retrievedReimbursement = service.getCrewMemeberReimbursements(employee.getActive().getCrewNumber());
	 		ctx.json(retrievedReimbursement);
	 		//ctx.result("Reimbursement findByCrewNUmber works!");
	 		}
	 		
	 		
	 		public static void createReimbursement(Context ctx) throws SQLException{
	 			String tempAmount = ctx.req.getParameter("amount");
		 		double doubleAmount = Double.parseDouble(tempAmount);
		 		ReimbursementDAO dao = new ReimbursementDAO();
	 			Reimbursement reimbursement = new Reimbursement(
	 					doubleAmount,
	 					ctx.req.getParameter("description"),
	 					ctx.req.getParameter("status"),
	 					employee.getActive());	
	 					dao.save(reimbursement);
	 					ctx.redirect("home.html");
	 		}

	 		//jdbc get employee reimbursemnt
	 		public static void getCrewReimbursements(Context ctx) throws SQLException{
	 			List<Reimbursement> tempList;
	 			ReimbursementDAO dao = new ReimbursementDAO(ConnectionFactory.getConnection());
	 			tempList = dao.getAll(employee.getActive().getCrewNumber());
	 			ctx.json(tempList);
	 		}
	 		
	 		
	 		

	 		public static void update(Context ctx) throws SQLException{
	 			
		 		ReimbursementDAO dao = new ReimbursementDAO();
	 			ReimbursementDAO testJDBC = new ReimbursementDAO(ConnectionFactory.getConnection());
	 			
	 			System.out.println("hi");
	 			
	 			String tempCaseNumber = ctx.req.getParameter("caseNumber");
		 		int intCaseNumber = Integer.parseInt(tempCaseNumber);
		 		ctx.redirect("Manager.html");
		 		
		 		Reimbursement newReimbursement = new Reimbursement(
		 				intCaseNumber,
		 				ctx.req.getParameter("status")
		 				);
		 			testJDBC.update(newReimbursement);
	 		}
}