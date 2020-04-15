package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a subclass of User. It is for the Staff using the system.
 * @author Emily Wells.
 * @version 1.0.
 */
public class Staff extends User {

    private String StaffType;
    /**
     * This is the constructor for a staff object
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public Staff(final int userID_, final String firstName_, final String lastName_, final String StaffType_){
        super(userID_, firstName_, lastName_);
        StaffType = StaffType_;
    }

    /**
     * This allows a staff member to log into the system with a valid userID.
     * @param userID
     * @return
     * @Override User login().
     */
    public boolean login(int userID) {
        //TO DO: if the ID is in the database it returns true, else if returns false
        return false;
    }

    /**
     * This method will return the staff type.
     */
    public String get_staffType(){
        return StaffType;
    }

    /**
     * This method will set the staff type
     */
    public void set_staffType(String staffType){
        StaffType = staffType;
    }

    /**
     * This method will delete instance of the staff member in the database.
     * @throws SQLException
     */
    public void deleteUserInDB() throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        String id = Integer.toString(get_userID());

        try {
            //Connect to the Database.
            Class.forName("com.mysql . jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhoast:3306/RestaurantDB", "root", "6Ylime93");

            //create a string that holds the user query with 'X' as user inputs.
            String sql = "DELETE from UserProfiles WHERE 'ID' = ?" + id + " AND UserType = Staff";

            //prepare the query
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) con.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }
    /**
     * This method will write the instance of the customer into the database.
     * @throws SQLException
     */
    public void insertUserInDB() throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int id = get_userID();

        try {
            //Connect to the Database.
            Class.forName("com.mysql . jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhoast:3306/RestaurantDB", "root", "6Ylime93");

            //create a string that holds the user query with 'X' as user inputs.
            String sql = "INSERT INTO UserProfile (firstName, lastName, address, StaffType)" + "WHERE ID = id AND UserType = Staff" + "VALUES (x, x, x, x)";

            //prepare the query
            preparedStatement = con.prepareStatement(sql);

            //bind the values to the parameters
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, StaffType);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) con.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }

    /**
     * This method will update the Staff details in the database.
     * @throws SQLException
     */
    public void updateUserInDB() throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            //Connect to the Database.
            Class.forName("com.mysql . jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "6Ylime93");

            //create a string that holds the user query with 'X' as user inputs.
            String sql = "UPDATE user SET firstName = x, lastName = x, StaffType = x" + "WHERE ID = x AND UserType = Staff";

            //prepare the query
            preparedStatement = con.prepareStatement(sql);

            //bind the values to the parameters
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, StaffType);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) con.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    /**
     * This returns the order, specified, that has been placed.
     * @param orderID
     */
    public void /*String[]*/ getOrderInformation(int orderID){
        //TO DO amend with reference to orders class
        return;
    }
}

