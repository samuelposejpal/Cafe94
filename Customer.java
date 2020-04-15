package sample; /**
 * Customer class to create a Customer object and extra functionality of the Customer.
 * @author Emily Wells
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents the Customer with a first and last name, user ID and address.
 * @author Emily Wells.
 * @version 1.0.
 */
public class Customer extends User {
    private static String address;

    /**
     * Create a customer object with an ID, name and address.
     * @param userID_
     * @param firstName_
     * @param lastName_
     * @param address_
     */
    public Customer(final int userID_, final String firstName_, final String lastName_, final String address_){
        super(userID_, firstName_, lastName_);
        address = address_;
    }

    /**
     * Login using user ID. if the ID exists in the system then user is granted access.
     * @param userID
     * @return boolean
     */
    @Override
    public boolean login(int userID){
        int ID = this.get_userID();
        return ID == userID;
    }

    /**
     * For changing the address of a customer.
     * @param address
     */
    public void set_address(String address) { address = Customer.address;}

    /**
     * For retrieving the address of a customer.
     * @return
     */
    public static String get_address() { return address;}

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
            String sql = "INSERT INTO UserProfile (userID, firstName, lastName, address)" + "WHERE ID = id AND UserType = Customer" + "VALUES (x, x, x)";

            //prepare the query
            preparedStatement = con.prepareStatement(sql);

            //bind the values to the parameters
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, address);

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
            String sql = "UPDATE user SET firstName = x, lastName = x, address = x" + "WHERE ID = x AND UserType = Customer";

            //prepare the query
            preparedStatement = con.prepareStatement(sql);

            //bind the values to the parameters
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, address);

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
     * This method will delete the instance of the customer in the database.
     * @throws SQLException
     */
    public void deleteCustomerInDB() throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        String id = Integer.toString(get_userID());

        try {
            //Connect to the Database.
            Class.forName("com.mysql . jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhoast:3306/RestaurantDB", "root", "6Ylime93");

            //create a string that holds the user query with 'X' as user inputs.
            String sql = "DELETE from UserProfiles WHERE 'ID' = " + id + " AND UserType = Customer";

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
     * Returns past orders of a customer.
     */
    public void /*String[]*/ getPastOrders(){
        //TO DO need to implement with order methods
    }

    /**
     * Returns past bookings of a customer.
     */
    public void /*String[]*/ getPastBookings(){
        //TO DO need to implement with booking class
    }

    /**
     * Returns future bookings of a customer.
     */
    public void /*String[]*/ getFutureBookings(){
        //TO DO need to implement with booking class
    }
}
