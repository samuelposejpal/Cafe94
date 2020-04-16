package sample;


import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class customerFoodMenuController implements Initializable {

    @FXML
    private Button menuContinueButton;

    @FXML
    private Spinner<?> garlicBreadSpin;

    @FXML
    private Spinner<?> tomatoSoupSpin;

    @FXML
    private Spinner<?> cheeseburgerChipsSpin;

    @FXML
    private Spinner<?> ceasarSaladSpin;

    @FXML
    private Spinner<?> spagBolSpin;

    @FXML
    private Spinner<?> fishChipsSpin;

    @FXML
    private Spinner<?> vegChilliSpin;

    @FXML
    private Spinner<?> cokeSpin;
    @FXML
    private Spinner<?> orangeJuiceSpin;

    @FXML
    private Spinner<?> chefSpinner;

        /**
         * When this method is called, it will change the Scene to
         * foodSelection.fxml. continue button pressed.
         */
      public void homeButtonPushed(ActionEvent event) throws Exception {
            Parent waiterMenuParent = FXMLLoader.load(getClass().getResource("waiterMenu.fxml"));
            Scene waiterMenuScene = new Scene(waiterMenuParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setMaximized(true);
            window.setScene(waiterMenuScene);
            window.setTitle("Waiter Menu");
            window.show();
        }

    @FXML
    public void goBackCustomer(ActionEvent event) throws IOException {
        Parent backOne = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Scene backOneScene = new Scene(backOne);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(backOneScene);
        window.show();
    }


    public void deliveryChoiceButtonPressed(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("thankyouOrder.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //get the stage from the event that was passed in.
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        stage.setTitle("Order Summary");
        stage.setScene(scene);
        stage.show();
    }
    public void collectionChoiceButtonPressed(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("thankyouOrderDelivery.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //get the stage from the event that was passed in.
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        stage.setTitle("Order Summary");
        stage.setScene(scene);
        stage.show();
    }
          /*  Parent foodSelectParent = FXMLLoader.load(getClass().getResource("foodSelection.fxml"));
            Scene foodSelectScene = new Scene(foodSelectParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setMaximized(true);
            window.setScene(foodSelectScene);
            window.setTitle("Order Summary");
            window.show();
        }

*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}

