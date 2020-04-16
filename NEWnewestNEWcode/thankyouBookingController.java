package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;


public class thankyouBookingController {

        @FXML
        private Button goHomeThanks;
        @FXML
        private Button goBackThanks;

        @FXML
        public void goHomeTY(ActionEvent event) throws IOException {
            Parent thanksToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
            Scene thanksToHomeScene = new Scene(thanksToHome);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(thanksToHomeScene);
            window.show();
        }

        @FXML
        public void goBackBookRequest(ActionEvent event) throws IOException {
            Parent backBookRequest = FXMLLoader.load(getClass().getResource("bookingRequest.fxml"));
            Scene backBookRequestScene = new Scene(backBookRequest);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(backBookRequestScene);
            window.show();
        }
}
