package sample;
/** 
*@author Niamh Murphy-Mauchline 
*/
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class bookingRequestController implements Initializable {

    @FXML
    private Button homeClick;
    @FXML
    private Button backClick;
    @FXML
    private DatePicker DateClick;
    @FXML
    private TextField arriveHr;
    @FXML
    private TextField arriveMin;
    @FXML
    private TextField departHr;
    @FXML
    private TextField departMin;
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

    private Connection connection;
    private PreparedStatement pst;

    /** 
    *Takes the user to the login scene, logs the user out
    */
    @FXML
    public void goHomePage(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();
    }
    /** Takes the user back to the Booking menu page */
    @FXML
    public void goBackBookingHome(ActionEvent event) throws IOException {
        Parent backBookingHome = FXMLLoader.load(getClass().getResource("bookingMenu.fxml"));
        Scene backBookingHomeScene = new Scene(backBookingHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(backBookingHomeScene);
        window.show();
    }

    /** Allows the user to make selections via spinners, text and a date picker, that is then used to populate the future bookings table in the database
    *Then takes the user to the thank you for booking page
    */
    @FXML
    public void goRequestApprove(ActionEvent event) throws IOException, SQLException {

            String insert = "INSERT INTO Future_Bookings(Booking_ID,Date_Time,Customer,Guests,Table_ID)"+
                    "VALUES (?,?,?,?,?)";
            try {
                connection = dbconnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            pst = connection.prepareStatement(insert);

            java.sql.Date DatePickerDate = java.sql.Date.valueOf(DateClick.getValue());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = dateFormat.format(DatePickerDate);

            int value = (Integer) guestsClick.getValue();
            String strValue = Integer.toString(value);

            pst.setNString(1, "0");
            pst.setString(2, strDate);
            pst.setNString(3,"98765");
            pst.setString(4, strValue);
            pst.setNString(5,"1");


            pst.executeUpdate();

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
