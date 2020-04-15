package sample; /**
 * Controller class for managers view of all staff profiles.
 * @author Emily Wells
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AllStaffProfilesController implements Initializable {
    @FXML private TableView<Staff> staffProfiles;
    @FXML private TableColumn<Staff, Integer> userID;
    @FXML private TableColumn<Staff, String> firstName;
    @FXML private TableColumn<Staff, String> lastName;
    @FXML private TableColumn<Staff, String> staffType;
    @FXML private Label errMsgLabel;

    /**
     * Initialises the controller class and loads the staff profiles into the table.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //configure the table columns
        this.userID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("userID"));
        this.firstName.setCellValueFactory(new PropertyValueFactory<Staff, String>("First Name"));
        this.lastName.setCellValueFactory(new PropertyValueFactory<Staff, String>("LastName"));
        this.staffType.setCellValueFactory(new PropertyValueFactory<Staff, String>("Staff Type"));

        errMsgLabel.setText("");

        try{
            loadStaff();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method will load the staff details from the database.
     */
    public void loadStaff() throws SQLException {

        ObservableList<Staff> staff = FXCollections.observableArrayList();

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            //connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "6Ylime93");

            //create a statement
            statement = conn.createStatement();

            //create SQL query
            rs = statement.executeQuery("SELECT 'ID' 'first_name' 'last_name' 'StaffType' FROM UserProfile WHERE UserType = 'Staff' ");

            //create a staff object for each record that is loctated in the table.
            while(rs.next()){
                Staff newStaff = new Staff(rs.getInt("ID"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("Staff"));
                staff.add(newStaff);
            }
            staffProfiles.getItems().addAll(staff);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally
        {

            if(conn != null) conn.close();

            if(statement != null) statement.close();
            if(rs != null) rs.close();

        }

    }


}

