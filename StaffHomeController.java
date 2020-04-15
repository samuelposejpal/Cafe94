package sample; /**
 * Controller class for the home page of staff.
 * @auther Emily Wells
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffHomeController {
    StaffHomeModel staffhomeModel = new StaffHomeModel();

    @FXML Button managerButton;
    @FXML Button waiterButton;
    @FXML Button chefButton;
    @FXML Button deliveryDriverButton;
    @FXML Button logoutButton;
    @FXML private Label status1;
    @FXML private Label status2;

    private Staff staff;

    //set the userID and type of staff.
    int userId = staff.get_userID();
    String type = staff.get_staffType();

    /**
     * Initializes the controller class
     */
    public void initialize(URL url, ResourceBundle rb){
        //disable all buttons unless the right staff member is clicking it.
        managerButton.setDisable(true);
        chefButton.setDisable(true);
        deliveryDriverButton.setDisable(true);
        waiterButton.setDisable(true);

        //connect to the database
        if (this.staffhomeModel.isDBConnected()) {
            this.status1.setText("Connected to Database");
        } else {
            status1.setText("Not Connected to Database");
        }
    }

    /**
     * This will take the staff user back to the login page.
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {
        //create a scene base on the loaded FXML scene graph
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "sample/loginPage.fxml", "Login Page");
    }

    /*
     * This method will take the manager to their appropriate login page.
     * @param event
     */
    public void managerButtonPushed(ActionEvent event){
        try{
            if (this.staffhomeModel.isStaffHome(Integer.toString(this.userId), this.type)) {
                Stage stage = (Stage) this.managerButton.getScene().getWindow();
                stage.close();
                //check if the user is a manager, if so disable the button and allow the functionality.
                if (this.type == "Manager") {
                    managerButton.setDisable(false);
                    ManagerHome();
                }
                else {
                    this.status2.setText("Wrong user ID");
                }
            }
            else {
                this.status2.setText("Wrong user ID");
            }
        }
        catch (Exception localException){
        }
    }


    /*
     * This method will take the manager to their appropriate login page.
     * @param event
     */
    public void waiterButtonPushed(ActionEvent event){
        try{
            if (this.staffhomeModel.isStaffHome(Integer.toString(this.userId), this.type)) {
                Stage stage = (Stage) this.waiterButton.getScene().getWindow();
                stage.close();
                //check if the user is a waiter, if so disable the button and allow the functionality.
                if (this.type == "Waiter") {
                    waiterButton.setDisable(false);
                    WaiterHome();
                }
                else {
                    this.status2.setText("Wrong user ID");
                }
            }
            else {
                this.status2.setText("Wrong user ID");
            }
        }
        catch (Exception localException){
        }
    }

    /*
     * This method will take the manager to their appropriate login page.
     * @param event
     */
    public void chefButtonPushed(ActionEvent event){
        try{
            if (this.staffhomeModel.isStaffHome(Integer.toString(this.userId), this.type)) {
                Stage stage = (Stage) this.chefButton.getScene().getWindow();
                stage.close();
                //check if the user is a chef, if so disable the button and allow the functionality.
                if (this.type == "Chef") {
                    chefButton.setDisable(false);
                    ChefHome();
                }
                else {
                    this.status2.setText("Wrong user ID");
                }
            }
            else {
                this.status2.setText("Wrong user ID");
            }
        }
        catch (Exception localException){
        }
    }

    /*
     * This method will take the manager to their appropriate login page.
     * @param event
     */
    public void deliveryDriverButtonPushed(ActionEvent event){
        try{
            if (this.staffhomeModel.isStaffHome(Integer.toString(this.userId), this.type)) {
                Stage stage = (Stage) this.deliveryDriverButton.getScene().getWindow();
                stage.close();
                //check if the user is a delivery driver, if so disable the button and allow the functionality.
                if (this.type == "Delivery Driver") {
                    deliveryDriverButton.setDisable(false);
                    DeliveryDriverHome();
                }
                else {
                    this.status2.setText("Wrong user ID");
                }
            }
            else {
                this.status2.setText("Wrong user ID");
            }
        }
        catch (Exception localException){
        }
    }

    /**
     * This method is helper method to take the Manager to their home page.
     */
    private void ManagerHome(){
        try{
            Stage userStage = new Stage();
            FXMLLoader chefLoader = new FXMLLoader();
            Pane root = (Pane)chefLoader.load(getClass().getResource("sample/ManagerHomepageView.fxml").openStream());

            ChefHomepageController ChefHPController = (ChefHomepageController)chefLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Manager Homepage");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is to take the Chef to their home page.
     */
    private void ChefHome(){
        try{
            Stage userStage = new Stage();
            FXMLLoader chefLoader = new FXMLLoader();
            Pane root = (Pane)chefLoader.load(getClass().getResource("staffViews/ChefHomepageView.fxml").openStream());

            ChefHomepageController ChefHPController = (ChefHomepageController)chefLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Chef Homepage");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is to take the Waiter to their home page.
     */
    private void WaiterHome(){
        try{
            Stage userStage = new Stage();
            FXMLLoader WaiterLoader = new FXMLLoader();
            Pane root = (Pane)WaiterLoader.load(getClass().getResource("sample/WaiterHomepageView.fxml").openStream());

            WaiterHomepageController WaiterHPController = (WaiterHomepageController)WaiterLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Waiter Homepage");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is to take the Delivery Driver to their home page.
     */
    private void DeliveryDriverHome(){
        try{
            Stage userStage = new Stage();
            FXMLLoader DeliveryDriverLoader = new FXMLLoader();
            Pane root = (Pane)DeliveryDriverLoader.load(getClass().getResource("sample/DeliveryDriverHomepageView.fxml").openStream());

            DeliveryDriverHomepageController DeliveryDriverHPController = (DeliveryDriverHomepageController)DeliveryDriverLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("DeliveryDriver Homepage");
            userStage.setResizable(false);
            userStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
