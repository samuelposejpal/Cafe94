import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.sql.ResultSet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class foodMenuController implements Initializable {

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

    //foodMenuModel = new foodMenuModel

    @FXML
    public void ContinueButtonPushed(ActionEvent event) throws IOException {
        Parent requestApprove = FXMLLoader.load(getClass().getResource("foodSelection.fxml"));
        Scene requestApproveScene = new Scene(requestApprove);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(requestApproveScene);
        window.show();
    }

    //Label label = new Label("Daily Special:");
    //final Spinner<Integer> spinner = new Spinner<Integer>();
    //final int initialValue = 0;

    @FXML
    public void goHomePage(ActionEvent event) throws IOException {
        Parent bookingToHome = FXMLLoader.load(getClass().getResource("loginimproved.fxml"));
        Scene bookingToHomeScene = new Scene(bookingToHome);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookingToHomeScene);
        window.show();
    }

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

        SpinnerValueFactory<Integer> OrangeJuice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.OrangeJuiceClick.setValueFactory(OrangeJuice);
        OrangeJuiceClick.setEditable(true);

        errMsgLabel.setText("");
    }
    //create delivery and input it into database
            @FXML
            public void createDeliveryButtonPushed(ActionEvent event) throws IOException, SQLException {
            String insert = "INSERT INTO currentorder(CustomerID,OrderType)"+
                    "VALUES (?,?)";
            try {
                connection = dbconnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            pst = connection.prepareStatement(insert);

            pst.setString(1, " ");
            pst.setString(2, CustomerIDTextField.getText());
            pst.setString(5,"Collection");

            pst.executeUpdate();

            Parent createProfileB = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
            Scene createProfileBScene = new Scene(createProfileB);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(createProfileBScene);
            window.show();
        }
        public String enteredID() throws SQLException {
            String insert = "SELECT ID FROM UserProfile WHERE ID = ?)";

            connection = dbconnection.getConnection();

            pst = connection.prepareStatement(insert);
            pst.setString(1, userIDTextField.getText());
            ResultSet rs=pst.executeQuery();
            String id = rs.getString("ID");
            return id;

        }
    //create eat-in by waiter and input it into database
    @FXML
    public void createEatInButtonPushed(ActionEvent event) throws IOException, SQLException {
        String insert = "INSERT INTO currentorder(CustomerID,OrderType)"+
                "VALUES (?,?)";
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pst = connection.prepareStatement(insert);

        pst.setString(1, " ");
        pst.setString(2, CustomerIDTextField.getText());
        pst.setString(5,"Delivery");

        pst.executeUpdate();

        Parent createProfileB = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene createProfileBScene = new Scene(createProfileB);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(createProfileBScene);
        window.show();
    }
    public String enteredID() throws SQLException {
        String insert = "SELECT ID FROM UserProfile WHERE ID = ?)";

        connection = dbconnection.getConnection();

        pst = connection.prepareStatement(insert);
        pst.setString(1, userIDTextField.getText());
        ResultSet rs=pst.executeQuery();
        String id = rs.getString("ID");
        return id;

    }

    //create collection and input it into database
    @FXML
    public void createCollectionButtonPushed(ActionEvent event) throws IOException, SQLException {
        String insert = "INSERT INTO currentorder(CustomerID,OrderType)"+
                "VALUES (?,?)";
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pst = connection.prepareStatement(insert);

        pst.setString(1, " ");
        pst.setString(2, CustomerIDTextField.getText());
        pst.setString(5,"Delivery");

        pst.executeUpdate();

        Parent createProfileB = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene createProfileBScene = new Scene(createProfileB);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(createProfileBScene);
        window.show();
    }
    public String enteredID() throws SQLException {
        String insert = "SELECT ID FROM UserProfile WHERE ID = ?)";

        connection = dbconnection.getConnection();

        pst = connection.prepareStatement(insert);
        pst.setString(1, userIDTextField.getText());
        ResultSet rs=pst.executeQuery();
        String id = rs.getString("ID");
        return id;

    }




    }
