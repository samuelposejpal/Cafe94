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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
*This class controlls the customer profile page. 
*/
public class CustomerProfileController implements Initializable {


    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField userID;
    @FXML private TextField address;
    @FXML private Button homeButton;
    @FXML private Button editProfileButton;
    @FXML private Button logoutButton;
    @FXML private Label errMsgLabel;

    private Customer customer;
    private Connection connection;


    /**
     * Initializes the controller class.
     */
    public void initialize (URL url, ResourceBundle rb){
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    /**
     * Preloads the data for the current customer.
     * @param customer
     */
    public void preloadData(Customer customer){

        this.customer = customer;

        // Update the GUI to show the existing data.
        firstName.setText(customer.get_firstName());
        lastName.setText(customer.get_lastName());
        userID.setText(customer.get_userID());
        address.setText(customer.get_address());
    }

    /**
     * This will take the cutomer back to the homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "customerMenu.fxml", "Homepage");
    }


    /**
     * This will take the Customer to edit their profile.
     */
    public void editProfileButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "NewProfileView.fxml", "New Profile Page");
    }

    /**
     * This will take the Customer back to the login page.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "loginPage.fxml", "Login Page");
    }
}
