package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Controller class for tracking orders.
 * @author Emily Wells
 */

public class chefOrderManagerController {
    @FXML private TableView<Order> orderTable;
    @FXML private TableColumn<Staff, Integer> orderID;
    @FXML private TableColumn<Staff, String> items;
    @FXML private TableColumn<Staff, String> tableNumber;
    @FXML private TableColumn<Staff, String> timeOrdered;

    @FXML private Button logout;
    @FXML private Button complete;

    @FXML private Label errMsgLabel;
    private Order orders;

    /**
     * Initialises the controller class and loads the staff profiles into the table.
     */
    public void initialize(URL location, ResourceBundle resources) {
        //disable the edit button until a staff member has been selected from the table
        complete.setDisable(true);
        errMsgLabel.setText("");
        //configure the table columns
        orderID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("orderID"));
        items.setCellValueFactory(new PropertyValueFactory<Staff, String>("Menu_Item"));
        tableNumber.setCellValueFactory(new PropertyValueFactory<Staff, String>("Table_Number"));
        timeOrdered.setCellValueFactory(new PropertyValueFactory<Staff, String>("DateTime"));

        try{
            loadOrders();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method will load the staff details from the database.
     */
    public void loadOrders() throws SQLException {

        ObservableList<Staff> staff = FXCollections.observableArrayList();

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            //connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "6Ylime93");

            //create a statement
            statement = conn.createStatement();

            //create SQL query
            rs = statement.executeQuery("SELECT * FROM Current_Order");

            //create a Order object for each record that is located in the table.
            while(rs.next()){
                staff.add(new Staff(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));

            }
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally
        {
            if(conn != null) conn.close();
            if(statement != null) statement.close();
            if(rs != null) rs.close();

        }
        orderID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("ID"));
        items.setCellValueFactory(new PropertyValueFactory<Staff, String>("first_name"));
        tableNumber.setCellValueFactory(new PropertyValueFactory<Staff, String>("last_name"));
        timeOrdered.setCellValueFactory(new PropertyValueFactory<Staff, String>("staffType"));
        orderTable.setItems(orders);
    }


    /**
     * This is the method for when the logout button is pushed.
     * @param event
     * @throws IOException
     */
    public void logoutButtonPushed(ActionEvent event) throws IOException {

        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/loginPage.fxml", "Login Page");
    }

    /**
     * This will take the Staff back to the staff homepage.
     */
    public void homeButtonPushed(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScenes(event, "/sample/StaffHome.fxml", "Homepage");
    }

    /**
     * Refresh the displayed countries.
     */
    private void refreshTable() throws SQLException {
        // Clear the displayed list
        orderTable.getItems().clear();
        //load the staff from the database again.
        loadOrders();
    }

    /**
     * This will complete and remove the selected order  and refresh the displayed table.
     */
    private void completeButtonPushed() throws SQLException {
        // Get the selected staff item in the table.
        Order order = this.orderTable.getSelectionModel().getSelectedItem();

        // Check if user selected an item
        if (order == null) {
            // Show a message
            errMsgLabel.setText("you have not selected a staff member");

        }
        else {
            orderSelectedEdit();
            // Remove the staff selected.
            order.deleteOrderInDB(order.get_OrderID());
        }

        // Refresh the updated table
        refreshTable();
    }

    /**
     * If a staff member has been selected in the table, enable the edit button
     */
    public void orderSelectedEdit()
    {
        complete.setDisable(false);
    }
}


