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

/**
 * Controller class for scene that is generated once a booking has been placed.
 * @author Niamh Murphy-Mauchline
 */

public class thankyouBookingController {

        @FXML
        private Button goHomeThanks;
        @FXML
        private Button goBackThanks;

        /**
        * Returns to the login scene when button is pushed.
        */
        @FXML
        public void goHomeTY(ActionEvent event) throws IOException {
            Parent thanksToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
            Scene thanksToHomeScene = new Scene(thanksToHome);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(thanksToHomeScene);
            window.show();
        }
        
        /**
        * Returns the user back one scene to the booking request page.
        */
        @FXML
        public void goBackBookRequest(ActionEvent event) throws IOException {
            Parent backBookRequest = FXMLLoader.load(getClass().getResource("bookingRequest.fxml"));
            Scene backBookRequestScene = new Scene(backBookRequest);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(backBookRequestScene);
            window.show();
        }
}
