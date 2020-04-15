package sample; /**
 * Login Controller Class helper.
 * @author Emily Wells
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbUtil.dbConnection;


public class LoginModel {
    Connection connection;

    public LoginModel(){
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

    public boolean isLogin(String userid, String opt) throws Exception{

        PreparedStatement ps = null;
        ResultSet resultSet = null;

        //  create a query string with ? used instead of the values given by the user
        String sql = "SELECT * FROM UserProfile WHERE ID = ? AND UserType = ?";

        try{
            //  prepare the statement
            ps = this.connection.prepareStatement(sql);

            // bind the userID to the ? and usertype to ?
            ps.setString(1, userid);
            ps.setString(2, opt);

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

