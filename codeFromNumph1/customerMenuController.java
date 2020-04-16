package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class customerMenuController {

    @FXML
    private Button goBooking;
    @FXML
    private Button goMenu;
    @FXML
    private Button custProfile;
    @FXML
    private Button viewHist;
    @FXML
    private Button logout;

    private Connection connection;

    public void initialize (URL url, ResourceBundle rb){
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goBooking(ActionEvent event) throws IOException {
        Parent custtoBook = FXMLLoader.load(getClass().getResource("bookingMenu.fxml"));
        Scene custtoBookScene = new Scene(custtoBook);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(custtoBookScene);
        window.show();
    }

    @FXML
    public void goMenu(ActionEvent event) throws IOException {
        Parent custtoMenu = FXMLLoader.load(getClass().getResource("waiterMenu.fxml"));
        Scene custtoMenuScene = new Scene(custtoMenu);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(custtoMenuScene);
        window.show();
    }

    @FXML
    public void goProfile(ActionEvent event) throws IOException {
        Parent custtoProfile = FXMLLoader.load(getClass().getResource("customerProfile .fxml"));
        Scene custtoProfileScene = new Scene(custtoProfile);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(custtoProfileScene);
        window.show();
    }

    @FXML
    public void goLogout(ActionEvent event) throws IOException {
        Parent custtologout = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene custtologoutScene = new Scene(custtologout);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(custtologoutScene);
        window.show();
    }

    /*@FXML
    public void goHistory(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();
    }*/
}
