package sample;
import java.sql.*;

/**
 * This class represents the construction of reports time/date period.
 * @author Emily Wells and Niamh Murphy-Mauchline
 * @version 2.0
 */

public class Report {
    // The instance variables:
    /*private final int period;*/
    private final int sDate;
    private final int eDate;
    private final int eTime;
    private final int sTime;

    /**
     * This creates a report period for a specified data and time.
     * @param sDate_
     * @param eDate_
     * @param sTime_
     * @param eTime_
     */
    // The constructor for date AND time (setting the data):
    public Report(final int sDate_, final int eDate_, final int sTime_, final int eTime_) {
        /*this.period = 0;*/
        sDate = sDate_;
        eDate = eDate_;
        sTime = sTime_;
        eTime = eTime_;
    }

    /**
     * This creates a report period for a specified date.
     * @param sDate_
     * @param eDate_
     */
    //constructor for just date.
    public Report(final int sDate_, final int eDate_) {
        /*this.period = 0;*/
        this.sTime = 0;
        this.eTime = 0;
        sDate = sDate_;
        eDate = eDate_;
    }

	  //The methods: TO DO this is to be coded in SQL for retrieval from Database
	  public static void mostPopularItem(){
          // establish DB url
          String url = "jdbc:mysql://localhost:3306/restaurant";

          try {
              // Establish a DB Connection Object
              Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");

              // create a statement object to send to the db
              Statement statement = conn.createStatement();
              String sql = "SELECT Menu_Item, COUNT(*) AS magnitude \n" +
                      "FROM Past_Orders \n" +
                      "GROUP BY Menu_Item \n" +
                      "ORDER BY magnitude DESC\n" +
                      "LIMIT 1;";
              // execute statement object by running
              // query and storing results in
              // a resultSet
              ResultSet resultSet = statement.executeQuery(sql);

              // process the result with a loop
              while (resultSet.next()) {
                  System.out.println(resultSet.getString("Menu_Item"));
              }
              return;

          } catch (SQLException e) {
              System.out.println("Error connecting to DB: " + e.getMessage());
          }


      }


	 public void busiestPeriod(Report period){
	 // establish DB url
          String url = "jdbc:mysql://localhost:3306/restaurant";

          try {
              // Establish a DB Connection Object
              Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");

              // create a statement object to send to the db
              Statement statement = conn.createStatement();
              String sql = "SELECT date(Date_Time) AS busiest_day\n" +
                      "FROM Past_Bookings \n" +
                      "WHERE ((Date_Time >= 'sDate') & (Date_Time <= 'eDate'))\n" +
                      "GROUP BY busiest_day \n" +
                      "ORDER BY count(*) DESC \n" +
                      "LIMIT 1;";
              // execute statement object by running
              // query and storing results in
              // a resultSet
              ResultSet resultSet = statement.executeQuery(sql);

              // process the result with a loop
              while (resultSet.next()) {
                  System.out.println(resultSet.getString("Menu_Item"));
              }
              return;

          } catch (SQLException e) {
              System.out.println("Error connecting to DB: " + e.getMessage());
          }
	  }


	  public void mostActiveCustomer(Report period) {
          // establish DB url
          String url = "jdbc:mysql://localhost:3306/restaurant";

          try {
              // Establish a DB Connection Object
              Connection conn = DriverManager.getConnection(url, "root", "Aishai3f");

              // create a statement object to send to the db
              Statement statement = conn.createStatement();
              String sql = "SELECT CustomerID, COUNT(*) AS magnitude \n" +
                      "FROM Past_Orders\n" +
                      "WHERE ((Date_Time >= 'sDate') & (Date_Time <= 'eDate'))\n" +
                      "GROUP BY CustomerID\n" +
                      "ORDER BY magnitude DESC\n" +
                      "LIMIT 1;";
              // execute statement object by running
              // query and storing results in
              // a resultSet
              ResultSet resultSet = statement.executeQuery(sql);

              // process the result with a loop
              while (resultSet.next()) {
                  System.out.println(resultSet.getString("Menu_Item"));
              }
              return;

          } catch (SQLException e) {
              System.out.println("Error connecting to DB: " + e.getMessage());
          }
	  }
}