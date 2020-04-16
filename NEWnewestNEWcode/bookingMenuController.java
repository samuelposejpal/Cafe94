package sample;

/** @author Naimh Murphy-Mauchline */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class bookingMenuController {

    @FXML
    private Button goBackBookMenu;
    @FXML
    private Button goHomeBookMenu;
    @FXML
    private Button upcomingBookings;
    @FXML
    private Button placeBookings;

    /** Returns user to login page when button has been pushed*/
    @FXML
    public void goHomeBookMenu(ActionEvent event) throws IOException {
        Parent goHomeBookM = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene goHomeBookMScene = new Scene(goHomeBookM);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goHomeBookMScene);
        window.show();
    }
   /**Returns user to login page when button is pushed */
    @FXML
    public void goBackBookMenu(ActionEvent event) throws IOException {
        Parent goBackBookM = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene goHomeBackMScene = new Scene(goBackBookM);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goHomeBackMScene);
        window.show();
    }
    /** Changes the scene to the booking request scene */
    @FXML
    public void goRequestBooking(ActionEvent event) throws IOException {
        Parent goRequestBook = FXMLLoader.load(getClass().getResource("bookingRequest.fxml"));
        Scene goRequestBookScene = new Scene(goRequestBook);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goRequestBookScene);
        window.show();
    }
}
