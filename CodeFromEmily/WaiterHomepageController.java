package sample; /**
 * Waiter Homepage Controller Class.
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

public class WaiterHomepageController  {

    @FXML Button logout;
    @FXML Button newOrder;
    @FXML Button currentOrder;
    @FXML Button requests;

    /**
     * This will take the Customer back to their homepage.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }


}


