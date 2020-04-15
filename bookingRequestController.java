package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class bookingRequestController implements Initializable {

   // @FXML
    //private Button homeClick;
    //@FXML
    //private Button backClick;
    @FXML
    private DatePicker DateClick;
    //@FXML
    //private TextField arriveHr;
    //@FXML
    //private TextField arriveMin;
    //@FXML
    //private TextField departHr;
    //@FXML
    //private TextField departMin;
   @FXML
    private Spinner<Integer> guestsClick;
    @FXML
    private TextField notesClick;
    @FXML
    private Button requestClick;
    @FXML
    public void chooseDate(ActionEvent event) {
        LocalDate date = DateClick.getValue();
    }

    @FXML
    public void goHomePage(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();
    }

    @FXML
    public void goBackBookingHome(ActionEvent event) throws IOException {
        Parent backBookingHome = FXMLLoader.load(getClass().getResource("bookingMenu.fxml"));
        Scene backBookingHomeScene = new Scene(backBookingHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(backBookingHomeScene);
        window.show();
    }

    @FXML
    public void goRequestApprove(ActionEvent event) throws IOException {
        Parent requestApprove = FXMLLoader.load(getClass().getResource("thankyouBooking.fxml"));
        Scene requestApproveScene = new Scene(requestApprove);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(requestApproveScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         * This methods set how the spinner works and can choose an integer between 0 and 10
         */
        SpinnerValueFactory<Integer> guestsFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        this.guestsClick.setValueFactory(guestsFactory);
        guestsClick.setEditable(true);


    }

}
