package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is the class to connect to the database for the restaurant system.
 * @author Emily Wells
 */
public class dbconnection {

    private static final String username = "root";
    private static final String password = "Aishai3f";
    private static final String conn = "jdbc:mysql://localhost:3306/Restaurant";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //1.  connect to the DB
            return DriverManager.getConnection(conn, username, password);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}