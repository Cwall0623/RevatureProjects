package utils;

import Controllers.AccountController;

import Controllers.CustomerController;
import Controllers.NonStaticController;

import io.javalin.Javalin;
import java.sql.Connection;

public class EntryPoint {
    public static void main(String[] args) {

        //Javalin app = Javalin.create().start(7000);
        Connection conn = ConnectionFactory.getConnection();
        NonStaticController nonStaticController = new NonStaticController(app, conn);
        CustomerController.init(app);
        AccountController.init(app);
        
    }
}
