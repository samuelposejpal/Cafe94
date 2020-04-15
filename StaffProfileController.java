package sample; /**
 * Controller Class for staff profiles.
 * @author Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffProfileController implements Initializable {
    sample.HomeModel HomeModel = new HomeModel();

    @FXML Label firstName;
    @FXML Label lastName;
    @FXML Label userID;
    @FXML private Button homeButton;
    @FXML private Button logoutButton;
    @FXML private Label errMsgLabel;

    private Staff staff;


    /**
     * Initializes the controller class.
     */
    public void initialize (URL url, ResourceBundle rb){
        if (this.HomeModel.isDBConnected()) {
            this.errMsgLabel.setText("Connected to Database");
        } else {
            errMsgLabel.setText("Not Connected to Database");
        }
    }
    /**
     * Preloads the data for the current customer.
     * @param staff
     */
    public void preloadData(Staff staff){
        // Keep a reference to the country that we are editing.
        this.staff = staff;

        // Update the GUI to show the existing data.
        firstName.setText(staff.get_firstName());
        lastName.setText(staff.get_lastName());
        userID.setText(Double.toString(staff.get_userID()));
    }

    /**
     * This will take the Staff member back to the staff homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/StaffHome.fxml", "Homepage");
    }

    /**
     * This will take the Customer back to their homepage.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }
}

