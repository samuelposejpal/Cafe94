package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class orderCompletedController implements Initializable {

    public void goHome (ActionEvent event) throws Exception {
        Parent waiterMenuParent = FXMLLoader.load(getClass().getResource("waiterMenu.fxml"));
        Scene waiterMenuScene = new Scene(waiterMenuParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setMaximized(true);
        window.setScene(waiterMenuScene);
        window.setTitle("Homepage");
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
