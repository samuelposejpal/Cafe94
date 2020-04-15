package sample;

import java.sql.*;

/**
 * This is a subclass of User. It is for the Staff using the system.
 * @author Emily Wells and Niamh Murphy-Mauchline
 * @version 2.0.
 */
public class Staff extends User {

    /**
     * This is the constructor for a staff object
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public Staff(final int userID_, final String firstName_, final String lastName_){
        super(userID_, firstName_, lastName_);
    }

    /**
     * This allows a staff member to log into the system with a valid userID.
     * @param userID
     * @return
     * @Override User login().
     */
    public boolean login(int userID) {
        //TO DO: if the ID is in the database it returns true, else if returns false
        String url = "jdbc.mysql://localhost:8800/restaurant_database";
        boolean exists = false;

        try {
            Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");
            Statement statement = conn.createStatement();
            String sql = "SELECT EXISTS(SELECT * from UserProfile WHERE (Id = 'userID') & (UserType = 'Staff'));";
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

    /**
     * This returns the order, specified, that has been placed.
     * @param orderID
     */
    public void /*String[]*/ getOrderInformation(int orderID){
        //TO DO amend with reference to orders class
        return;
    }
}