package sample;

import java.sql.*;

/**
 * This is the Manager class, a subclass of staff.
 * @author Emily Wells and Niamh Murphy-Mauchline.
 * @version 2.0.
 */

public class Manager extends Staff{

    /**
     * This is the constructor for a manager object.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public Manager(final int userID_, final String firstName_, final String lastName_){
        super(userID_, firstName_, lastName_);
    }

    /**
     * This function allows a manager to create a new staff profile and it is added to the database.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public void setStaffProfile(final int userID_, final String firstName_, final String lastName_){
        Staff newMember = new Staff(userID_, firstName_, lastName_);
        //TO DO create SQL code to append  staff member to the database
            String url = "jdbc.mysql://localhost:8800/restaurant_database";

            try {
                Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO UserProfile (ID, first_name, second_name, UserType)\n" +
                        "VALUES ('userID_', 'firstName_', 'lastName_', 'Staff');";
                ResultSet resultSet = statement.executeQuery(sql);

                while(resultSet.next()) {
                    System.out.println(resultSet.getString("Menu_Item"));
                }

            } catch (SQLException var5) {
                System.out.println("Error connecting to DB: " + var5.getMessage());
            }
    }

    /**
     * This function allows the manager to edit a staff profile and it is adjusted in the database.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public void editStaffProfile(final int userID_, final String firstName_, final String lastName_){
        //TO DO edit in database, SQL coding needed
    }

    /**
     * This function allows a manager to delete a user profile from the database.
     * @param userID
     */
    private void deleteProfile(int userID){
        //TO DO edit in database, SQL coding needed
        String url = "jdbc.mysql://localhost:8800/restaurant_database";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");
            Statement statement = conn.createStatement();
            String sql = " DELETE FROM UserProfile WHERE ID = 'userID_';";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                System.out.println(resultSet.getString("Menu_Item"));
            }

        } catch (SQLException var5) {
            System.out.println("Error connecting to DB: " + var5.getMessage());
        }
    }

    /**
     * This function allows a manager to generate a reoprt for the specified data and time period.
     * @param sDate_
     * @param eDate_
     * @return
     */
    //TO DO un comment the functions that are called from 'reports' once reports is completed
    //manager can request reports
    private String requestReport(final int sDate_, final int eDate_){
        Report period = new Report(sDate_, eDate_);
        return "Most active customer: " /*+ mostActiveCustomer(period) */+ " Most popular item: " /*+ mostPopularItem(period)*/;

        //TO DO complete the rest with SQL code, and remove void
    }

    /**
     * This function allows a manager to generate a reoprt for the specified date period.
     * @param sDate_
     * @param eDate_
     * @return
     */
    //manager can request reports
    private String requestReport(final int sDate_, final int eDate_, final int sTime_, final int eTime_){
        Report period = new Report(sDate_, eDate_, sTime_, eTime_);
        return "Most active customer: " /*+ mostActiveCustomer(period) */+ " Most popular item: " /*+ mostPopularItem(period)*/;
        //TO DO complete the rest with SQL code, and remove void
    }
}