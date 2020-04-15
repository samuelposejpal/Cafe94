package sample; /**
 * Chef Home Page Controller Class.
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

public class ChefHomepageController implements Initializable {
    @FXML private Label errMsgLabel;
    @FXML private Button profileButton;
    @FXML private Button menuManagementButton;
    @FXML private Button completedOrdersButton;
    @FXML private Button currentOrdersButton;
    @FXML private Button logoutButton;

    /*
     * This will allow the chef to view their profile.
     * @param event
     */
    public void profileButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/StaffProfileView.fxml", "Staff Profile");
    }

    //TODO
    /*
     * This will allow the chef to view completed orders so they know to take the food to the table.
     * @param event
     */
    /*public void completedOrdersButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "CompletedOrdersView.fxml", "Completed Orders");
    }*/

    //TODO
    /*
     * This will allow the chef view orders that are pending.
     * @param event
     */
    /*public void currentOrdersButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "CurrentOrdersView.fxml", "Current Orders");
    }*/

    //TODO
    /*
     * This will allow the chef to......
     * @param event
     */
    /*public void menuManagementButtonPushed(ActionEvent event) throws IOException {

        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "menuManagementView.fxml", "Manage Menu");
    }*/


    /**
     * Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        errMsgLabel.setText("");

    }
}
