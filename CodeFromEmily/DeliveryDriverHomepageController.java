package sample; /**
 * Deliverly Driver Home page Controller Class.
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

public class DeliveryDriverHomepageController  {

    @FXML
    private Button currentOrders;
    @FXML
    private Button pastOrders;
    @FXML
    private Button profile;
    @FXML
    private Button logout;


    /**
     * This method will take the delivery driver to their profile page.
     */
    public void profileButtonPushed(ActionEvent event){
        //TODO
    }

    /*
     * This will take the staff member to the login page.
     * @param event
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }
}

