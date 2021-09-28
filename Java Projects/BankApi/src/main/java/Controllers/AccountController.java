package Controllers;

import java.sql.SQLException;
import java.util.List;

import daos.AccountDAO;
import daos.CustomerDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import nodels.Account;
import nodels.Customer;
import utils.ConnectionFactory;

public class AccountController {
	  private static Javalin javalin;

	    public static void init(Javalin app) {
	        javalin = app;
	        app.get("/testAccount", AccountController::testConnection);
	        app.get("/getCustomerAccounts/:customer_id", AccountController :: getCustomerAccounts);
	        app.get("/getAccountforCustomer/:account_id", AccountController:: getCertainAccount);
	        app.post("/createNewAccount/:customer_id", AccountController :: createNewAccount);
	       
	    }
	    public static void testConnection(Context ctx) {
	        ctx.status(200);
	        ctx.result("AccountController works");
	    }
	   
	    
	    public static void getCustomerAccounts(Context ctx) throws SQLException {
	    	AccountDAO dao = new AccountDAO(ConnectionFactory.getConnection());
	    	List<Account>tempList = dao.customerAccounts(Integer.parseInt(ctx.pathParam("customer_id")));
	    	ctx.json(tempList);
	    }

	    public static void getCertainAccount(Context ctx) throws SQLException{
	    	AccountDAO dao = new AccountDAO(ConnectionFactory.getConnection());
	    	Account row = dao.getAccount(Integer.parseInt(ctx.pathParam("account_id")));
	    	ctx.json(row);
	    }
	    public static void createNewAccount(Context ctx) throws SQLException{
	    	AccountDAO dao = new AccountDAO(ConnectionFactory.getConnection());
	    	Account row = ctx.bodyAsClass(Account.class);
	    	
	    	dao.save(row);
	    }
	 
	   
	   
	    }

