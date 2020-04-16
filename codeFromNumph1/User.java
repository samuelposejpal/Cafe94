package sample;

import java.sql.*;

public abstract class User {
    /**
     * Instance variables for a user.
     */
    public final String userID;
    public final String firstName;
    public final String lastName;

    // The constructor (setting the data):
    /**
     * Create a user with specified the parameters.
     * @param userID_, firstName_, lastName_.
     * @param userID_
     */
    public User(final String userID_, final String firstName_, final String lastName_) {
        if (userID_.isEmpty() ) {
            userID = "FAULT"; firstName = "FAULT"; lastName = "FAULT";;
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
    public String get_userID() { return userID; }

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

    public boolean login(int userID) {
        //TO DO: if the ID is in the database it returns true, else if returns false
        String url = "jdbc:mysql://localhost:3306/restaurant";
        boolean exists = false;

        try {
            Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");
            Statement statement = conn.createStatement();
            String sql = "SELECT EXISTS(SELECT * from UserProfile WHERE (Id = 'userID') & (UserType = 'Customer'));";
            ResultSet resultSet = statement.executeQuery(sql);
            if (isFilled(resultSet))
                exists = true;

            while(resultSet.next()) {
                System.out.println(resultSet.getString("Menu_Item"));
            }

        } catch (SQLException var5) {
            System.out.println("Error connecting to DB: " + var5.getMessage());
        }
        return exists;
    }

    public static boolean isFilled(ResultSet resultSet){
        boolean isEmpty = true;
        try {
            while(resultSet.next()){
                isEmpty = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !isEmpty;
    }

    // "toString" is a standardised name (in a sense -- actually it
    // "overrides" the (empty) method as it comes in the automatic
    // "base class" Object):
    public String toString() {
        return "userID=" + userID + ", name=\"" + firstName + " " + lastName;
    }
}
