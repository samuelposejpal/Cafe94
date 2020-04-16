package sample;
/**
 * Controller class for the home page of staff.
 * @auther Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffHomeController {

    @FXML Button waiterButton;
    @FXML Button chefButton;
    @FXML Button deliveryDriverButton;
    @FXML Button logoutButton;

    /**
     * This will take the staff user back to the login page.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }

    /**
     * This method is to take the Chef to their home page.
     */
    public void chefButtonPushed(ActionEvent event) throws IOException{

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/chefHomepageView.fxml", "home Page");
    }

    /**
     * This method is to take the Waiter to their home page.
     */
    public void waiterButtonPushed(ActionEvent event) throws IOException{

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/WaiterHomePageView.fxml", "home Page");
    }

    /**
     * This method is to take the Delivery Driver to their home page.
     */
    public void deliveryDriverButtonPushed(ActionEvent event) throws IOException{

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/DeliveryDriverHomepageView.fxml", "home Page");

    }


}
