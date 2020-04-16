package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class thankyouOrderController implements Initializable {


    @FXML
    public void goHomePage(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}