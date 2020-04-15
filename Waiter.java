package sample;

/**
 * This class represents a Waiter for the restaurant.
 * @author Emily Wells.
 * @version 1.0.
 */
public class Waiter extends Staff{


    /**
     * This is the constructor for a staff object
     *
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public Waiter(int userID_, String firstName_, String lastName_, String staffType_) {
        super(userID_, firstName_, lastName_, staffType_);
    }

    public boolean approveTableBooking(int orderID){
        boolean available = true;
        return available;
    }

    public boolean approveDeliveryRequest(int orderID) {
        boolean available = true;
        return available;
    }
}

