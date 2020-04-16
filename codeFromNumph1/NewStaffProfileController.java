package sample;

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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewStaffProfileController implements Initializable {

    @FXML private TextField userID;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField role;
    @FXML private Button CreateProfileButton;
    @FXML private Button CancelButton;
    @FXML private Label errMsgLabel;
    @FXML
    Pane rootPane;

    private Staff staff;
    private Connection connection;
    private PreparedStatement pst;

    public NewStaffProfileController() throws IOException {
    }


    /**
     * This will update the changes made to a user profile, when the button is pushed and take the user back to the profile page.
     * @param event
     * @throws IOException
     */
    public void cancelButtonPushed(ActionEvent event) throws IOException {

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/AllStaffProfilesView.fxml", "Login Page");
    }

    /**
     * This will take the Customer back to their homepage.
     */
    @FXML
    public void createProfileButtonPushed(ActionEvent event) throws IOException, SQLException {
            String insert = "INSERT INTO UserProfile(ID,first_name,second_name,UserType,StaffType)"+
                    "VALUES (?,?,?,?,?)";
            try {
                connection = dbconnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            pst = connection.prepareStatement(insert);

            pst.setString(1, userID.getText());
            pst.setString(2, firstNameTextField.getText());
            pst.setString(3, lastNameTextField.getText());
            pst.setNString(4,"Staff");
            pst.setString(5, role.getText());


            pst.executeUpdate();

            Parent goStaffView = FXMLLoader.load(getClass().getResource("StaffProfileView.fxml"));
            Scene goStaffViewScene = new Scene(goStaffView);
            Stage window_ = (Stage)((Node)event.getSource()).getScene().getWindow();
            window_.setScene(goStaffViewScene);
            window_.show();
    }

    /**
     * initialises controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errMsgLabel.setText("");
    }
}

