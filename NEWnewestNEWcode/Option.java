package sample; /**
 * Helper class for choosing user type at login.
 * @author Emily Wells
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class hold the methods for the choice of user for the system.
 * @author Emily Wells
 */
public enum Option {
    Staff, Customer;

    private Option(){}

    public String value(){
        return name();
    }

    public static Option fromValue(String v){

        return valueOf(v);
    }
}