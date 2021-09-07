package Controllers;

import java.sql.SQLException;
import java.util.List;

import daos.AccountDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import nodels.Account;
import utils.ConnectionFactory;

public class AccountController {
	  private static Javalin javalin;

	    public static void init(Javalin app) {
	        javalin = app;
	        app.get("/testAccount", AccountController::testConnection);
	        app.post("/postAccount/:id", TestController::insertTestData);
	        //app.get("/test/:id", TestController::getById);
	        app.get("/getCustomerAccounts/:customer_id", AccountController :: getCustomerAccounts);
	        app.get("/getAccountforCustomer/:junction_id", AccountController:: getCertainAccount);
	        
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
	    	Account row = dao.getAccount(Integer.parseInt(ctx.pathParam("junction_id")));
	    	ctx.json(row);
	    }

}
