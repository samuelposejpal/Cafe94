package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStaffProfileController implements Initializable {

    @FXML private TextField userID;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField role;
    @FXML private Button CreateProfileButton;
    @FXML private Button CancelButton;
    @FXML private Label errMsgLabel;
    @FXML
    Pane rootPane;

    private Staff staff;



    /**
     * This will update the changes made to a user profile, when the button is pushed and take the user back to the profile page.
     * @param event
     * @throws IOException
     */
    public void cancelButtonPushed(ActionEvent event) throws IOException {

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/AllStaffProfilesView.fxml", "Login Page");
    }

    /**
     * This will take the Customer back to their homepage.
     */
    public void createProfileButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/StaffProfileView.fxml", "Profile Page");
    }

    /**
     * initialises controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errMsgLabel.setText("");
    }
}

