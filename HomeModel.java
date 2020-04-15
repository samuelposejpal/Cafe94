package sample;

/**
 * This is the helped class for directing a staff member to their appropriate homepage.
 */

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeModel {
    Connection connection;


    public HomeModel(){
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


    public boolean isDBConnected(){
        return this.connection != null;
    }

    public boolean isHomepage(int userid, String staffType) throws Exception{

        PreparedStatement ps = null;
        ResultSet resultSet = null;

        //  create a query string with ? used instead of the values given by the user
        String sql = "SELECT * FROM UserProfile WHERE ID = ? AND UserType = ?";

        try{
            //  prepare the statement
            ps = this.connection.prepareStatement(sql);

            // bind the userid to the ? and userType to ?
            ps.setString(1, String.valueOf(userid));
            ps.setString(2, staffType);

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

