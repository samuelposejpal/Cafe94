package sample;
/**
 * Edit profile (Staff/Manager view) Controller Class.
 * @author Emily Wells
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * This is the controller class for the edit profile page.
 */
public class EditStaffProfileController extends ControllerClass implements Initializable {

    @FXML
    private TextField userID;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField staffType;
    @FXML private Button saveChangesButton;
    @FXML private Button deleteProfileButton;
    @FXML private Button homeButton;
    @FXML private Button goToProfilePageButton;
    @FXML private Label errMsgLabel;
    @FXML
    Pane rootPane;

    private Staff staff;



    /**
     * This will update the changes made to a staff profile, when the button is pushed and take the user back to the profile page.
     * @param event
     * @throws IOException
     */
    public void saveChangesButtonPushed(ActionEvent event) throws IOException, SQLException {

        try{
            //update current user.
            if(staff != null){
                updateUser();
                staff.updateUserInDB();
            }
            //create a new user of the system.
            else{
                staff = new Staff(userID.getText(), firstName.getText(), lastName.getText(), staffType.getText());
                //don't show errors if creating a user was successful
                errMsgLabel.setText("");
                staff.insertUserInDB();
            }
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "sample/StaffProfile.fxml", "profileView");
        }
        catch (SQLException e) {
            errMsgLabel.setText(e.getMessage());
        }
    }

    /**
     * This will take the staff back to their homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        /*EditProfileController editProfile = new EditProfileController();*/
        sc.changeScenes(event, "/sample/StaffHome.fxml", "Homepage");
    }

    /**
     * This method will update the view with a staff object preloaded for an edit.
     * @param user
     */
    @Override
    public void preloadData(User user){
        // Keep a reference to the country that we are editing.
        this.staff = staff;

        // Update the GUI to show the existing data.
        firstName.setText(staff.getFirstName());
        lastName.setText(staff.getLastName());
        userID.setText(staff.getUserID());
        staffType.setText(staff.getStaffType());

    }

    /**
     * initialises controller class.
     */
    @Override
    public void initialize() {

        errMsgLabel.setText("");
    }

    /**
     * This method will read from the GUI fields and update the staff object.
     */
    public void updateUser(){
        staff.setFirstName(firstName.getText());
        staff.setLastName(lastName.getText());
        staff.setStaffType(staffType.getText());
    }

    /**
     * Preloads the data for the current staff.
     * @param staffToEdit
     */
    public void preloadData(Staff staffToEdit){
        // Keep a reference to the country that we are editing.
        this.staff = staffToEdit;

        // Update the GUI to show the existing data.
        firstName.setText(staff.getFirstName());
        lastName.setText(staff.getLastName());
        userID.setText(staff.getUserID());
        staffType.setText(staff.getStaffType());

    }


    /**
     * Close the window.
     */
    private void closeWindow() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    /**
     *  Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){


        errMsgLabel.setText("");

    }
}

