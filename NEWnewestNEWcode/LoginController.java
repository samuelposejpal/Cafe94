package sample;
/*
Controller class for Login view.
@author Emily Wells
 */

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.sql.Connection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    loginModel loginModel = new loginModel();

    @FXML private Button loginButton;
    @FXML private Button createProfileButton;
    @FXML TextField userID;
    @FXML private Label errMsgLabel;
    @FXML private ComboBox<Option> userType;

    @FXML private Label loginStatus;
    @FXML Pane root;


    private Customer customer;
    private Staff staff;
    private Connection connection;


    /**
     * Initializes the controller class.
     */
    public void initialize (URL url, ResourceBundle rb){
        try {
            connection = dbconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.userType.setItems(FXCollections.observableArrayList(Option.values()));

    }

    //This will allow a user to login to the system and take them to the home page.
    public void loginButtonPushed(ActionEvent event) throws IOException {
        try{
            if(this.loginModel.isLogin(this.userID.getText(), ((Option)this.userType.getValue()).toString())){
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                switch (((Option)this.userType.getValue()).toString()) {
                    case "Customer":
                        customerLogin();
                        break;
                    case "Staff":
                        staffLogin();
                        break;
                }
            }
            else {
                this.loginStatus.setText("Wrong user ID");
            }
        }
        catch (Exception localException){

        }
    }

    //code for customer login
    public void customerLogin(){
        try{
                    Stage userStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Pane root = (Pane)loader.load(getClass().getResource("CustomerHomePageView.fxml").openStream());

                    CustomerHomePageController custHPController = (CustomerHomePageController)loader.getController();

                    Scene scene = new Scene(root);
                    userStage.setScene(scene);
                    userStage.setTitle("Customer Homepage");
                    userStage.setResizable(false);
                    userStage.show();

                }
                catch (IOException e){
                    e.printStackTrace();
                }


    }

    //code for Staff login
    public void staffLogin(){
        try{
            Stage userStage = new Stage();
            FXMLLoader managerLoader = new FXMLLoader();
            Pane root = (Pane)managerLoader.load(getClass().getResource("StaffHome.fxml").openStream());

            //StaffHomeController managerHPController = (StaffHomeController)managerLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Staff Homepage");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
     * This will allow the user to create a profile.
     * @param event
     */
    public void createProfileButtonPushed(ActionEvent event) throws Exception {

        Parent custLogParent =FXMLLoader.load(getClass().getResource("NewProfileView.fxml"));
        Scene custLogScene = new Scene(custLogParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setMaximized(true);
        window.setScene(custLogScene);
        window.setTitle("New profile page");
        window.show();
    }
}