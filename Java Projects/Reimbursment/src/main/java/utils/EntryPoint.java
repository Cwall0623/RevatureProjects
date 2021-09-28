package utils;

import java.sql.Connection;

import Controller.EmployeeController;
import Controller.ReinbursementController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class EntryPoint {
	
	    public static void main(String[] args) {

	        Javalin app = Javalin.create().start(7000);
	        Connection conn = ConnectionFactory.getConnection();
	       app.after(ctx -> {
	    	   ctx.res.addHeader("Access-Control-Allow-Origin", "null");
	       });
	        
	       EmployeeController.init(app);
	       ReinbursementController.init(app);
	       app.config.addStaticFiles("static",Location.CLASSPATH);
	    }
}
