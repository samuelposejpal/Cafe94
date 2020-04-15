/**
 * Controller Class for staff profiles.
 * @author Emily Wells
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerProfileController implements Initializable {
    sample.HomeModel HomeModel = new HomeModel();

    @FXML Label firstName;
    @FXML Label lastName;
    @FXML Label userID;
    @FXML Label address;
    @FXML private Button homeButton;
    @FXML private Button editProfileButton;
    @FXML private Button logoutButton;
    @FXML private Label errMsgLabel;

    private Customer customer;


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
     * @param customer
     */
    public void preloadData(Customer customer){
        // Keep a reference to the country that we are editing.
        this.customer = customer;

        // Update the GUI to show the existing data.
        firstName.setText(customer.get_firstName());
        lastName.setText(customer.get_lastName());
        userID.setText(Double.toString(customer.get_userID()));
        address.setText(customer.get_address());
    }

    /**
     * This will take the Staff member back to the staff homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/CustomerHomePageView.fxml", "Homepage");
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

