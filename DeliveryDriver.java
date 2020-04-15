package sample;

/**
 * This class represents a Delivery Driver for the restaurant.
 * @author Emily Wells.
 * @version 1.0.
 */
public class DeliveryDriver extends Staff {
    /**
     * This is the constructor for a staff object
     *
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public DeliveryDriver(int userID_, String firstName_, String lastName_, String staffType_) {

        super(userID_, firstName_, lastName_, staffType_);
    }

    /**
     * This returns a customer address for delivery purposes.
     * @return
     */
    public String getAddress(){
        String address = Customer.get_address();
        return address;
    }
}

