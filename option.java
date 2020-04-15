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
public enum option {
    Staff, Customer;

    private option(){}

    public String value(){
        return name();
    }

    public static option fromValue(String v){

        return valueOf(v);
    }
}

