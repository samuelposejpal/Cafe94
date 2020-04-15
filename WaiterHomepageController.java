package sample; /**
 * Waiter Homepage Controller Class.
 * @author Emily Wells
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class WaiterHomepageController implements Initializable {
    @FXML
    private Label errMsgLabel;

    /**
     * Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        errMsgLabel.setText("");

    }
}


