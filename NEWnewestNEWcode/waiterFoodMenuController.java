package sample;
/** 
*@author Samuel Posejpal */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import static javafx.application.Application.launch;

public class waiterFoodMenuController implements Initializable {

    @FXML public Spinner <Integer> DailySpecialClick;
    @FXML
    public Spinner<Integer> GarlicBreadClick;

    @FXML
    public Spinner<Integer> TomatoSoupClick;
    @FXML
    public Spinner<Integer> CheesburgerAndChipsClick;
    @FXML
    public Spinner<Integer> CaesarSaladClick;
    @FXML
    public Spinner<Integer> SpagettiBologneseClick;
    @FXML
    public Spinner<Integer> FishAndChipsClick;
    @FXML
    public Spinner<Integer> VegetarianChilliClick;
    @FXML
    public Spinner<Integer> CocaColaClick;
    @FXML
    public Spinner<Integer> OrangeJuiceClick;

    @FXML public Button ContinueButton;
    @FXML public Button GoBack;
    @FXML public Button GoHome;
    @FXML public Spinner<Integer> foodMenuClick;

    //foodMenuModel = new foodMenuModel
    /** Changes scene to an order complete scene */
    @FXML
    public void ContinueButtonPushed(ActionEvent event) throws IOException {
        Parent requestApprove = FXMLLoader.load(getClass().getResource("orderCompleted.fxml"));
        Scene requestApproveScene = new Scene(requestApprove);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(requestApproveScene);
        window.show();
    }

    //Label label = new Label("Daily Special:");
    //final Spinner<Integer> spinner = new Spinner<Integer>();
    //final int initialValue = 0;
    /** returns the user to the login page when the button is pressed*/
    @FXML
    public void goHomePage(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();
    }
    /** Takes the user back one scene*/
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Parent backOne = FXMLLoader.load(getClass().getResource("waiterMenu.fxml"));
        Scene backOneScene = new Scene(backOne);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(backOneScene);
        window.show();
    }
    /** Initialises the controller class and sets up the different spinners for choosing the quantity of items*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerValueFactory<Integer> DailySpecial = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.DailySpecialClick.setValueFactory(DailySpecial);
        DailySpecialClick.setEditable(true);

        SpinnerValueFactory<Integer> GarlicBread = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.GarlicBreadClick.setValueFactory(GarlicBread);
        GarlicBreadClick.setEditable(true);

        SpinnerValueFactory<Integer> TomatoSoup = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.TomatoSoupClick.setValueFactory(TomatoSoup);
        TomatoSoupClick.setEditable(true);

        SpinnerValueFactory<Integer> CheesburgerAndChips = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.CheesburgerAndChipsClick.setValueFactory(CheesburgerAndChips);
        CheesburgerAndChipsClick.setEditable(true);

        SpinnerValueFactory<Integer> CaesarSalad = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.CaesarSaladClick.setValueFactory(CaesarSalad);
        CaesarSaladClick.setEditable(true);

        SpinnerValueFactory<Integer> SpagettiBolognese = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.SpagettiBologneseClick.setValueFactory(SpagettiBolognese);
        SpagettiBologneseClick.setEditable(true);

        SpinnerValueFactory<Integer> FishAndChips = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.FishAndChipsClick.setValueFactory(FishAndChips);
        FishAndChipsClick.setEditable(true);

        SpinnerValueFactory<Integer> VegetarianChilli = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.VegetarianChilliClick.setValueFactory(VegetarianChilli);
        VegetarianChilliClick.setEditable(true);

        SpinnerValueFactory<Integer> CocaCola = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.CocaColaClick.setValueFactory(CocaCola);
        CocaColaClick.setEditable(true);

        SpinnerValueFactory<Integer>  OrangeJuice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.OrangeJuiceClick.setValueFactory(OrangeJuice);
        OrangeJuiceClick.setEditable(true);







    }
}
