package sample;

import javafx.beans.property.*;

/**
 * Created by Niamh Murphy-Mauchline
 */
public class Userss {
    //Declare Employees Table Columns
    private IntegerProperty ID;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone_number;
    private StringProperty UserType;
    private StringProperty StaffType;

    //Constructor
    public Userss() {
        this.ID = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.phone_number = new SimpleStringProperty();
        this.UserType = new SimpleStringProperty();
        this.StaffType = new SimpleStringProperty();
    }

    //employee_id
    public int getID() {
        return ID.get();
    }

    public void setID(int ID){
        this.ID.set(ID);
    }

    public IntegerProperty IDProperty(){
        return ID;
    }

    //first_name
    public String getfirstName () {
        return firstName.get();
    }

    public void setfirstName(String firstName){
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    //last_name
    public String getlastName () {
        return lastName.get();
    }

    public void setlastName(String lastName){
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }


    //phone_number
    public String getphoneNumber () {
        return phone_number.get();
    }

    public void setphoneNumber (String phoneNumber){
        this.phone_number.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phone_number;
    }

    //UserType
    public String getUserType () {
        return UserType.get();
    }

    public void setUserType(String lastName){
        this.UserType.set(lastName);
    }

    public StringProperty UserTypeProperty() {
        return UserType;
    }

    //StaffType
    public String getStaffType () {
        return StaffType.get();
    }

    public void setStaffType(String lastName){
        this.StaffType.set(lastName);
    }

    public StringProperty StaffTypeProperty() {
        return StaffType;
    }
}