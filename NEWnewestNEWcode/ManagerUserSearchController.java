package sample;
/** @author Niamh Murphy-Mauchline */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Userss;
import sample.DBEmp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ManagerUserSearchController{

    @FXML
    private TextField IDText;
    @FXML
    private TextArea resultsArea;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private Button addBttn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private TableView UsersTable;
    @FXML
    private TableColumn<Userss, Integer>  IDColumn;
    @FXML
    private TableColumn<Userss, String>  firstNameColumn;
    @FXML
    private TableColumn<Userss, String> lastNameColumn;
    @FXML
    private TableColumn<Userss, String> phoneNumberColumn;
    @FXML
    private TableColumn<Userss, String> UserTypeColumn;
    @FXML
    private TableColumn<Userss, String> StaffTypeColumn;

    /** a function to search for a user by ID */
        @FXML
        private void searchUser(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
            try {
                //Get Employee information
               Userss user = DBEmp.searchUser(IDText.getText());
                //Populate Employee on TableView and Display on TextArea
                populateAndShowUser(user);
            } catch (SQLException e) {
               e.printStackTrace();
               resultsArea.setText("Error occurred while getting employee information from DB.\n" + e);
                throw e;
         }
     }


    @FXML
    private void searchUsers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Userss> userData = DBEmp.searchUsers();
            //Populate Employees on TableView
            populateUsers(userData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    /**Initializing the controller class.
    *This method is automatically called after the fxml file has been loaded.
    */
    @FXML
    private void initialize () {
        IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        UserTypeColumn.setCellValueFactory(cellData -> cellData.getValue().UserTypeProperty());
        StaffTypeColumn.setCellValueFactory(cellData -> cellData.getValue().StaffTypeProperty());
    }

   
    @FXML
    private void populateUsers (Userss user) throws ClassNotFoundException {
        
        ObservableList<Userss> userData = FXCollections.observableArrayList();
        
        userData.add(user);
       
        UsersTable.setItems(userData);
    }

    
    @FXML
    private void setUserInfoToTextArea ( Userss user) {
        resultsArea.setText("ID" + user.getID() + "First Name: " + user.getfirstName() + "\n" +
                "Last Name: " + user.getlastName());
    }

    
    @FXML
    private void populateAndShowUser(Userss user) throws ClassNotFoundException {
        if (user != null) {
            populateUsers(user);
            setUserInfoToTextArea(user);
        } else {
            resultsArea.setText("This user does not exist!\n");
        }
    }

    
    @FXML
    private void populateUsers (ObservableList<Userss> userData) throws ClassNotFoundException {
        //Set items to the employeeTable
        UsersTable.setItems(userData);
    }


    
    @FXML
    private void insertUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            DBEmp.insertUser(IDText.getText(), firstNameText.getText(),lastNameText.getText());
            resultsArea.setText("User inserted! \n");
        } catch (SQLException e) {
            resultsArea.setText("Problem occurred while inserting User " + e);
            throw e;
        }
    }

    
    @FXML
    private void deleteUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            DBEmp.deleteUserWithId(IDText.getText());
            resultsArea.setText("User deleted! User id: " + IDText.getText() + "\n");
        } catch (SQLException e) {
            resultsArea.setText("Problem occurred while deleting User " + e);
            throw e;
        }
    }

}
