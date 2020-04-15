package sample; /**
 * Helper Scene Changer Class.
 * @author Emily Wells
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    private static User loggedInUser;


    /**
     * This method will accept the title of the new scene, the .fmxl file name for the
     * view and the ActionEvent that triggered that change.
     */
    public void changeScenes(ActionEvent event, String viewName, String title) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewName));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //get the stage from the event that was passed in.
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * This method will change scenes and preload the next scene with a user object.
     */
    public void changeScenes(ActionEvent event, String viewName, String title, User user, ControllerClass controllerClass) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewName));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //access the controller class to preload the data.
        controllerClass = loader.getController();
        controllerClass.preloadData(user);

        //get the stage from the event that was passed in.
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method will change scenes and preload the next scene with a customer object.
     */
    public void changeScenes(ActionEvent event, String viewName, String title, Customer customer, ControllerClass controllerClass) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewName));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //access the controller class to preload the data.
        controllerClass = loader.getController();
        controllerClass.preloadData(customer);

        //get the stage from the event that was passed in.
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method will change scenes and preload the next scene with a staff object.
     */
    public void changeScenes(ActionEvent event, String viewName, String title, Staff staff, ControllerClass controllerClass) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewName));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //access the controller class to preload the data.
        controllerClass = loader.getController();
        controllerClass.preloadData(staff);

        //get the stage from the event that was passed in.
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    public static int getLoggedInUser(int id){
        int userNum =  Integer.parseInt(findStartNum(id));
        return userNum;
    }

    public static void setLoggedInUser(User loggedInUser) {
        SceneChanger.loggedInUser = loggedInUser;
    }

    /**
     * helper method to find the starting character of a user ID.
     * @param userID
     */
    private static String findStartNum(int userID){
        String id = String.valueOf(userID);
        String firstNum = id.substring(0);
        return firstNum;
    }


    public static class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }
}
