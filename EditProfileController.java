package sample; /**
 * Edit profile (customer view) Controller Class.
 * @author Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * This is the controller class for the edit profile page.
 */
public class EditProfileController extends ControllerClass implements Initializable {

    @FXML private TextField userID;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField address;
    @FXML private Button saveChangesButton;
    @FXML private Button deleteProfileButton;
    @FXML private Button homeButton;
    @FXML private Button goToProfilePageButton;
    @FXML private Label errMsgLabel;
    @FXML Pane rootPane;

    private Customer customer;



    /**
     * This will update the changes made to a user profile, when the button is pushed and take the user back to the profile page.
     * @param event
     * @throws IOException
     */
    public void saveChangesButtonPushed(ActionEvent event) throws IOException, SQLException {

        try{
            //update current user.
            if(customer != null){
                updateUser();
                customer.updateUserInDB();
            }
            //create a new user of the system.
            else{
                customer = new Customer(Integer.parseInt(userID.getText()), firstName.getText(), lastName.getText(), address.getText());
                //don't show errors if creating a user was successful
                errMsgLabel.setText("");
                customer.insertUserInDB();
            }
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "sample/sample.fxml", "profileView");
        }
        catch (SQLException e) {
            errMsgLabel.setText(e.getMessage());
        }
    }

    /**
     * This will take the Customer back to their homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        /*EditProfileController editProfile = new EditProfileController();*/
        sc.changeScenes(event, "sample/customerHomePageView.fxml", "Homepage");
    }

    /**
     * This will take the user to their profile page if they have one.
     */
    public void goToProfileButtonPushed(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "sample/sample.fxml", "profileView");
    }

    /**
     * This will delete the customer profile when the button is pushed. Removing it from the database.
     * @param event
     * @throws IOException
     */
    public void deleteButtonPushed(ActionEvent event) throws IOException, SQLException {
        SceneChanger sc = new SceneChanger();
        int id = Integer.parseInt(userID.getText());
        customer.deleteCustomerInDB();
        LoginController loginPage = new LoginController();
        sc.changeScenes(event, "sample/loginView.fxml", "LoginPage");
    }

    /**
     * This method will update the view with a user object preloaded for an edit.
     * @param user
     */
    @Override
    public void preloadData(User user){
        // Keep a reference to the country that we are editing.
        this.customer = customer;

        // Update the GUI to show the existing data.
        firstName.setText(customer.get_firstName());
        lastName.setText(customer.get_lastName());
        userID.setText(Double.toString(customer.get_userID()));
        address.setText(customer.get_address());

    }

    /**
     * initialises controller class.
     */
    @Override
    public void initialize() {

        errMsgLabel.setText("");
    }

    /**
     * This method will read from the GUI fields and update the user object.
     */
    public void updateUser(){
        customer.set_firstName(firstName.getText());
        customer.set_lastName(lastName.getText());
        customer.set_address(address.getText());
    }

    /**
     * Preloads the data for the current user.
     * @param customerToEdit
     */
    public void preloadData(Customer customerToEdit){
        // Keep a reference to the country that we are editing.
        this.customer = customerToEdit;

        // Update the GUI to show the existing data.
        firstName.setText(customer.get_firstName());
        lastName.setText(customer.get_lastName());
        userID.setText(Double.toString(customer.get_userID()));
        address.setText(customer.get_address());

    }


    /**
     * Close the window.
     */
    private void closeWindow() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    /**
     *  Initialises controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){


        errMsgLabel.setText("");

    }
}

