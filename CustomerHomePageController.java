package sample;
/**
 * Customer Homepage Controller Class.
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

public class CustomerHomePageController implements Initializable {
    @FXML private Button profileButton;
    @FXML private Label errMsgLabel;
    @FXML private Button menuButton;
    @FXML private Button historyButton;
    @FXML private Button bookingsButton;
    @FXML private Button logoutButton;

    /*
     * This will take the customer to their profile page.
     * @param event
     */
    public void profileButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        /*EditProfileController editProfile = new EditProfileController();*/
        sc.changeScenes(event, "/customerViews/sample.fxml", "Profile Page");
    }

    /*
     * This will take the customer to the login page.
     * @param event
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "sample/loginPage.fxml", "Login Page");
    }

    //TODO
    /*
     * This will take the customer to the menu page.
     * @param event
     */
    /*public void menuButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "xxx.fxml", "Menu Page");
    }*/

    /*
     * This will take the customer to a menu page where they can view previous bookings and orders.
     * @param event
     */
    /*public void historyButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "xxx.fxml", "History Page");
    }*/

    /*
     * This will take the customer bookings page where they can request a table booking.
     * @param event
     */
    /*public void bookingButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "xxx.fxml", "Bookings Page");
    }*/

    /**
     * Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        errMsgLabel.setText("");

    }
}

