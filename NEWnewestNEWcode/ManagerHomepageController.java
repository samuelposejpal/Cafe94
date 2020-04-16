package sample; /**
 * Manager Homepage Controller Class.
 * @author Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerHomepageController {
    @FXML
    private Button logoutButton;
    @FXML
    private Button staffProfilesButton;
    @FXML
    private Button menuButton;
    @FXML
    private Button bookingsButton;
    @FXML
    private Button reportsButton;
    @FXML
    private Button userManagementButton;
    @FXML
    private Button historyButton;

    /**
     * This method will take the manager back to the main staff homepage.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/loginPage.fxml"));
        Scene scene = new Scene(parent);
    }

    /**
     * This method will take the manager to a table where they can view, edit and add staff profiles.
     */
    public void staffProfilesButtonPushed(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/AllStaffProfilesView.fxml"));
        Scene scene = new Scene(parent);
    }


}
