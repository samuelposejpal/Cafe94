package sample;


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

    @FXML
    public void goHomeBookMenu(ActionEvent event) throws IOException {
        Parent goHomeBookM = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene goHomeBookMScene = new Scene(goHomeBookM);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goHomeBookMScene);
        window.show();
    }

    @FXML
    public void goBackBookMenu(ActionEvent event) throws IOException {
        Parent goBackBookM = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene goHomeBackMScene = new Scene(goBackBookM);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goHomeBackMScene);
        window.show();
    }

    @FXML
    public void goRequestBooking(ActionEvent event) throws IOException {
        Parent goRequestBook = FXMLLoader.load(getClass().getResource("bookingRequest.fxml"));
        Scene goRequestBookScene = new Scene(goRequestBook);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(goRequestBookScene);
        window.show();
    }
}
