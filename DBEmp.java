package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBEmp {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Userss searchUser (String ID) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectQ = "SELECT * FROM UserProfile WHERE ID = "+ ID;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBConn.dbExecuteQuery(selectQ);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Userss user = getUserFromResultSet(rsEmp);

            //Return employee object
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + ID + " ID, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Userss getUserFromResultSet(ResultSet rs) throws SQLException
    {
        Userss User = null;
        if (rs.next()) {
            User = new Userss();
            User.setID(rs.getInt("ID"));
            User.setfirstName(rs.getString("firstName"));
            User.setlastName(rs.getString("lastName"));
            User.setphoneNumber(rs.getString("phoneNumber"));
            User.setUserType(rs.getString("UserType"));
            User.setUserType(rs.getString("StaffType"));

        }
        return User;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Userss> searchUsers () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectQ = "SELECT * FROM UserProfile";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUsers = DBConn.dbExecuteQuery(selectQ);

            //Send ResultSet to the getUsersList method and get employee object
            ObservableList<Userss> UsersList = getUserssList(rsUsers);

            //Return employee object
            return UsersList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Userss> getUserssList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Userss> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Userss emp = new Userss();
            emp.setID(rs.getInt("ID"));
            emp.setfirstName(rs.getString("firstName"));
            emp.setlastName(rs.getString("lastName"));
            emp.setphoneNumber(rs.getString("phoneNumber"));
            emp.setUserType(rs.getString("UserType"));
            emp.setStaffType(rs.getString("StaffType"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }


    //*************************************
    //DELETE an employee
    //*************************************
    public static void deleteUserWithId (String ID) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateQ =
                "BEGIN\n" +
                        "   DELETE FROM UserProfile\n" +
                        "         WHERE UserProfile ="+ ID +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBConn.dbExecuteUpdate(updateQ);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertUser (String ID, String firstName, String lastName) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateQ =
                "BEGIN\n" +
                        "INSERT INTO UserProfile\n" +
                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+ID+"','"+firstName+"','"+lastName+"', SYSDATE, 'IT_PROG');\n" +
                        "END;";

        //Execute DELETE operation
        try {
            DBConn.dbExecuteUpdate(updateQ);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
