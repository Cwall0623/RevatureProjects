 package Controller;

import org.eclipse.jetty.server.Server;

import daos.EmployeeDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Employee;

public class EmployeeController {

	private static Javalin javalin;
 	static Employee active = new Employee();
	static Employee guestEmployee = new Employee(1,"Brook1@gmail.com","IamBrook123", "Crew Member");

public static void init(Javalin app) {
		javalin = app;
        javalin.post("/login", EmployeeController::getUser);
        javalin.get("/testEmployee", EmployeeController::testEmployeeController);
        javalin.post("/logout", EmployeeController::logOut);
}
 		public static void testEmployeeController(Context ctx) {
 			ctx.status(200);
 			ctx.result("Reimbursement test Recieved");

 		}

 		public static void getUser (Context ctx) {
 			EmployeeDAO dao = new EmployeeDAO();
 			String crewEmail = ctx.req.getParameter("crewEmail");
 			String password = ctx.req.getParameter("password");
 			active = dao.findUser(crewEmail, password);
 			if(active == null) {
 				ctx.redirect("/Login.html");
 			}else if(active.getIsManager().equals("Crew Memeber")) {
 				
 				ctx.redirect("home.html");
 				System.out.println("The Employee is not null. you should now be granting a session");
 				
 				}
 			else {
				ctx.redirect("Manager.html");
 		}
 			
 			
 		}
		public static void logOut(Context ctx) {
			ctx.redirect("Login.html");
		}
 		
 		public  Employee getActive() {
			return active;
		}
		public  void setActive(Employee active) {
			EmployeeController.active = active;
		}
 		
}
