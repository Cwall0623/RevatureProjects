package Controllers;

import daos.TestTableDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import nodels.TestTable;
import utils.ConnectionFactory;
import java.sql.SQLException;

public class TestController {
    private static Javalin javalin;

    public static void init(Javalin app) {
        javalin = app;
        app.get("/test", TestController::testConnection);
        app.post("/test/:id", TestController::insertTestData);
        app.get("/test/:id", TestController::getById);

    }

    public static void testConnection(Context ctx) {
        ctx.status(200);
        ctx.result("Test Received!");
    }

    public static void insertTestData(Context ctx) throws SQLException {
        TestTableDAO dao = new TestTableDAO(ConnectionFactory.getConnection());
        TestTable row = ctx.bodyAsClass(TestTable.class);
        dao.save(row);
    }

    public static void getById(Context ctx) throws SQLException {
        TestTableDAO dao = new TestTableDAO(ConnectionFactory.getConnection());
        TestTable row = dao.get(Integer.parseInt(ctx.pathParam("id")));
        ctx.json(row);
    }

}