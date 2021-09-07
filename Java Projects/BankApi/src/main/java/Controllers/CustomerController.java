package Controllers;

import java.sql.SQLException;
import java.util.List;

import daos.CustomerDAO;
import daos.TestTableDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import nodels.Customer;
import nodels.TestTable;
import utils.ConnectionFactory;

public class CustomerController  {
	  private static Javalin javalin;

	    public static void init(Javalin app) {
	        javalin = app;
	        app.get("/testCustomer", CustomerController::testConnection);
	        app.get("/getCustomerId/:customer_id", CustomerController::getById);
	        //app.get("/getCustomertAccounts/:customer_id", CustomerController :: getCustomerAccounts);
	        app.get("/getAllCustomers", CustomerController::getAllCustomers);
	        app.post("/createNewCustomer", CustomerController::createNewCustomer);
	    }
	    public static void testConnection(Context ctx) {
	        ctx.status(200);
	        ctx.result("test works");
	    }

	    public static void getById(Context ctx) throws SQLException {
	        CustomerDAO dao = new CustomerDAO(ConnectionFactory.getConnection());
	        
	       Customer row =  dao.get(Integer.parseInt(ctx.pathParam("customer_id")));
	        ctx.json(row);

	    }

	    public static void getAllCustomers(Context ctx) throws SQLException {
	    	CustomerDAO dao = new CustomerDAO(ConnectionFactory.getConnection());
	    	List<Customer> temp = dao.getAll();
	    	
	    	
	    	ctx.json(temp);
	    }

	    public static void createNewCustomer(Context ctx) throws SQLException{
	    	CustomerDAO dao = new CustomerDAO(ConnectionFactory.getConnection());
	    	Customer row = ctx.bodyAsClass(Customer.class);
	    	
	    	dao.save(row);
	    }
}
	    	
	    	

