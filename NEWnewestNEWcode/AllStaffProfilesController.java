package sample;
/**
 * Controller class for managers view of all staff profiles.
 * @author Emily Wells
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AllStaffProfilesController {
    @FXML private TableView<Staff> staffProfiles;
    @FXML private TableColumn<Staff, Integer> userID;
    @FXML private TableColumn<Staff, String> firstName;
    @FXML private TableColumn<Staff, String> lastName;
    @FXML private TableColumn<Staff, String> staffType;
    @FXML private Label errMsgLabel;
    @FXML private Button editProfile;
    @FXML private Button deleteProfile;
    @FXML private Button createProfile;
    @FXML private Button logout;
    @FXML private Button home;
    private Staff staff;

    /**
     * Initialises the controller class and loads the staff profiles into the table.
     */
    public void initialize(URL location, ResourceBundle resources) {
        //disable the edit button until a staff member has been selected from the table
        editProfile.setDisable(true);
        deleteProfile.setDisable(true);

        //configure the table columns
        userID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("userID"));
        firstName.setCellValueFactory(new PropertyValueFactory<Staff, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastName"));
        staffType.setCellValueFactory(new PropertyValueFactory<Staff, String>("staffType"));

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
            rs = statement.executeQuery("SELECT 'ID' 'first_name' 'last_name' 'Stafftype' FROM UserProfile WHERE UserType = 'Staff'");

            //create a staff object for each record that is loctated in the table.
            while(rs.next()){
                staff.add(new Staff(rs.getString("ID"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5)));
                //           staff.add(newStaff);
            }
            //          staffProfiles.getItems().addAll(staff);
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally
        {
            if(conn != null) conn.close();
            if(statement != null) statement.close();
            if(rs != null) rs.close();

        }
        userID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("ID"));
        firstName.setCellValueFactory(new PropertyValueFactory<Staff, String>("first_name"));
        lastName.setCellValueFactory(new PropertyValueFactory<Staff, String>("last_name"));
        staffType.setCellValueFactory(new PropertyValueFactory<Staff, String>("staffType"));
        staffProfiles.setItems(staff);
    }

    /**
     * This method will allow the manager to edit the staff profile selected.
     */
    public void editProfileButtonPushed(ActionEvent event) throws IOException {

        //get the staff selected
        Staff staff = this.staffProfiles.getSelectionModel().getSelectedItem();

        if(staff == null){
            errMsgLabel.setText("No staff member selected");
        }
        else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/EditStaffProfile.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);

            //access the controller class to preload the data.
            StaffProfileController controllerClass = new StaffProfileController();
            controllerClass = loader.getController();
            controllerClass.preloadData(staff);
            //get the stage from the event that was passed in.
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setTitle("Edit Profile");
            stage.setScene(scene);
            stage.show();
        }
    }

    /*
     * This method will allow the manager to add another staff member to the database.
     * @param event
     */
    public void createProfileButtonPushed(ActionEvent event) throws Exception {
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/NewStaffProfile.fxml", "New profile Page");
    }

    /**
     * This is the method for when the logout button is pushed. It will take the managed to the login screen.
     * @param event
     * @throws IOException
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }

    /**
     * This will take the Manager back to the staff homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/StaffHome.fxml", "Homepage");
    }

    /**
     * Refresh the displayed countries.
     */
    private void refreshTable() throws SQLException {
        // Clear the displayed list
        staffProfiles.getItems().clear();
        //load the staff from the database again.
        loadStaff();
    }

    /**
     * Handle the behavior of the delete button.
     * This will delete the selected staff member and refresh the displayed table.
     */
    private void deleteButtonPushed() throws SQLException {
        // Get the selected staff item in the table.
        Staff staff = this.staffProfiles.getSelectionModel().getSelectedItem();

        // Check if user selected an item
        if (staff == null) {
            // Show a message
            errMsgLabel.setText("you have not selected a staff member");

        }
        else {
            staffSelectedEdit();
            // Remove the staff selected.
            staff.deleteUserInDB(staff.getUserID());
        }

        // Refresh the updated table
        refreshTable();
    }

    /**
     * If a staff member has been selected in the table, enable the edit button
     */
    public void staffSelectedEdit()
    {
        editProfile.setDisable(false);
    }

    /**
     * If a staff member has been selected in the table, enable the edit button.
     */
    public void staffSelectedDelete()
    {
        deleteProfile.setDisable(false);
    }

    /**
     * Preloads the staff data from the database.
     * @param staff
     */
    public void preloadData(Staff staff) {
        this.staff = staff;
        this.firstName.setText(staff.getFirstName());
        this.lastName.setText(staff.getLastName());
        this.userID.setText(staff.getUserID());
        this.staffType.setText(staff.getStaffType());
    }


    public void preloadData(User user) {

    }


    public void initialize() {

    }
}

