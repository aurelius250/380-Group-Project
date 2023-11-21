package hotel.prototype;

import java.util.ArrayList;

/**
 * 
 * @author tomc
 */
public class Customer {
    protected String customerName; 
    protected String customerEmail; 
    protected ArrayList reservationIDs; 
    
    /**
     * Method for taking customer object data and making it into a comma separated string
     * @return String of comma separated data from customer object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Customer Email: ").append(customerEmail).append("\n");
        sb.append("Reservation IDs: ").append(reservationIDs).append("\n");
        return sb.toString();
    }
    
    /**
     * Standard Customer class constructor
     */
    protected Customer() { 
        this.customerName = ""; 
        this.customerEmail = ""; 
        this.reservationIDs = new ArrayList<>();
    } 

    /**
      * Parameterized constructor
      * @param customerName
      * @param customerEmail
      * @param reservationIDs integer list of reservation ids associated with customer
      */
    protected Customer(String customerName, String customerEmail, ArrayList<Integer> reservationIDs) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.reservationIDs = reservationIDs;
    }    
    
    /**
     * Getter method for getting the name of the customer
     * @return String of customer name
     */
    protected String getCustomerName() {
        return customerName;
    }
    
    /**
     * Setter method for setting the customerName variable
     * @param customerName the name to be assigned to this customer object
     */
    protected void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter method for getting the email of the customer
     * @return String of customer email
     */
    protected String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Setter method for setting the customerEmail variable
     * @param customerEmail the string to set the customerEmail variable to
     */
    protected void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Getter method for getting the reservation IDs associated with customer
     * @return An ArrayList of reservationIDs
     */
    protected ArrayList<Integer> getReservationIDs() {
        return reservationIDs;
    }

    /**
     * Setter method for setting the reservationIDs list in customer object
     * @param reservationIDs ArrayList of Integers to be assigned to reservationIDs variable
     */
    protected void setReservationIDs(ArrayList<Integer> reservationIDs) {
        this.reservationIDs = reservationIDs;
    }
    
}
