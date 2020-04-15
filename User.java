package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the abstract class to create a user of the system. Superclass to Staff and Customer.
 * @author Emily Wells.
 * @version 1.0.
 */
public abstract class User {
    /**
     * Instance variables for a user.
     */
    public final int userID;
    public final String firstName;
    public final String lastName;

    // The constructor (setting the data):
    /**
     * Create a user with specified the parameters.
     * @param userID_, firstName_, lastName_.
     */
    public User(final int userID_, final String firstName_, final String lastName_) {
        if (userID_ <= 0) {
            userID = -1; firstName = "FAULT"; lastName = "FAULT";;
        }
        else {
            userID = userID_;
            firstName = firstName_;
            lastName = lastName_;
        }
    }

    // The methods:
    /**
     * These methods return the instance variables of a user.
     * @return the user userID.
     */
    public int get_userID() { return userID; }

    /**
     * These methods return the instance variables of a user.
     * @return the user first name.
     */
    public String get_firstName() { return firstName; }

    /**
     * These methods return the instance variables of a user.
     * @return the user last name.
     */
    public String get_lastName() { return lastName; }

    /**
     * These methods allow the user to set their details.
     * @param firstName the new ID component.
     */
    public void set_firstName(String firstName) { firstName = this.firstName; }

    /**
     * These methods allow the user to set their details.
     * @param lastName the new ID component.
     */
    public void set_lastName(String lastName) { lastName = this.lastName; }

    /**
     * This method allows the user to login. However this is specified in the specific user class, for example a staff member login, and customer login.
     * @overide login
     */
    public abstract boolean login(int userID);

    // "toString" is a standardised name (in a sense -- actually it
    // "overrides" the (empty) method as it comes in the automatic
    // "base class" Object):
    public String toString() {
        return "userID=" + userID + ", name=\"" + firstName + " " + lastName;
    }


}
