package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Report.mostPopularItem;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("bookingRequest.fxml"));
        primaryStage.setTitle("Application Test");
        primaryStage.setScene(new Scene(root, 729, 564));
        primaryStage.show();
        mostPopularItem();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
