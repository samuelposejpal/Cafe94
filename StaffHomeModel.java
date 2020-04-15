package sample; /**
 * Login Controller Class.
 * @author Emily Wells
 */

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffHomeModel {
    Connection connection;
    private Staff staff;

    int id = staff.get_userID();

    //connect to the database
    public StaffHomeModel(){
        try{
            this.connection = dbConnection.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(this.connection == null){
            System.exit(1);
        }
    }


    //check database is connected
    public boolean isDBConnected(){
        return this.connection != null;
    }

    //check what type of staff member
    public boolean isStaffHome(String id, String type) throws Exception{

        PreparedStatement ps = null;
        ResultSet resultSet = null;

        //  create a query string with ? used instead of the values given by the user
        String sql = "SELECT * FROM UserProfile WHERE ID = ? AND staffType = ? ";

        try{
            //  prepare the statement
            ps = this.connection.prepareStatement(sql);

            // bind the userID to the ?
            ps.setString(1, id);
            ps.setString(2, type);

            // execute the query
            resultSet = ps.executeQuery();

            boolean boll1;

            if(resultSet.next()){
                return true;
            }
            return false;
        }
        catch (SQLException e) {
            return false;
        }

        finally{
            ps.close();
            resultSet.close();
        }

    }

}

