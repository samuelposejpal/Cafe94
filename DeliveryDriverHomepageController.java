package sample; /**
 * Deliverly Driver Home page Controller Class.
 * @author Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryDriverHomepageController implements Initializable {
    @FXML
    private Label errMsgLabel;
    @FXML
    private Button currentOrders;
    @FXML
    private Button pastOrders;
    @FXML
    private Button profile;

    /**
     * Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        errMsgLabel.setText("");

    }

    /**
     * This method will take the delivery driver to their profile page.
     */
    public void profileButtonPushed(ActionEvent event){
        //TODO
    }
}

