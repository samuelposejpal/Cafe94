package sample; /**
 * New Profile Controller Class.
 * @author Emily Wells
 */

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

public class NewProfileController implements Initializable {

    @FXML private TextField userIDTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField addressTextField;
    @FXML private Button CreateProfileButton;
    @FXML private Button CancelButton;
    @FXML private Label errMsgLabel;


    private Customer customer;
    private Connection connection;
    private PreparedStatement pst;




    /**
     * This will update the changes made to a user profile, when the button is pushed and take the user back to the profile page.
     * @param event
     * @throws IOException
     */
    @FXML
    public void cancelButtonPushed(ActionEvent event) throws IOException {

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "loginPage.fxml", "Login Page");
    }

    /**
     * This will take the Customer back to their homepage.
     */
    @FXML
    public void createProfileButtonPushed(ActionEvent event) throws IOException, SQLException {
        String insert = "INSERT INTO UserProfile(ID,first_name,second_name,Address,UserType,StaffType)"+
                        "VALUES (?,?,?,?,?,?)";
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pst = connection.prepareStatement(insert);

        pst.setString(1, userIDTextField.getText());
        pst.setString(2, firstNameTextField.getText());
        pst.setString(3, lastNameTextField.getText());
        pst.setString(4, addressTextField.getText());
        pst.setNString(5,"Customer");
        pst.setNString(6," ");


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
    /**
     * initialises controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errMsgLabel.setText("");
    }
}