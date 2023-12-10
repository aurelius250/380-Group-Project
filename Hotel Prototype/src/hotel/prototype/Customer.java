package hotel.prototype;

import java.util.ArrayList;

/**
 * Object class representing users and their data
 * @author tomc
 */
public class Customer {
    
    protected boolean isAdmin;

    /**
     *  Name of the customer 
     */
    protected String customerName; 

    /**
     *  Customers email
     */
    protected String customerEmail; 
    
    /**
     *  Customers Password
     */
    protected String customerPassword;

    /**
     *  Reservation IDs associated with the customer
     */
    protected ArrayList<String> reservationIDs; 
    
    protected String customerAddress;
    protected int customerZip;
    protected int[] cardNum;
    protected String expiry;
    protected int[] phoneNum;
    protected int cvv;
    
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
    
    public String toStringCsv(){
        String s = Boolean.toString(isAdmin) + "," + 
               customerName + "," + customerEmail + "," + customerPassword;
        for(String x: reservationIDs){
            s += ",";
            s += x;
        }
        return s;
    }
    
    /**
     * Standard Customer class constructor
     */
    protected Customer() { 
        this.customerName = ""; 
        this.customerEmail = "";
        this.customerPassword = "";
        this.reservationIDs = null;
        this.customerAddress = "";
        this.customerZip = customerZip;
        this.cardNum = new int[16];
        this.expiry = "";
        this.phoneNum = new int[10];
        this.reservationIDs = new ArrayList<String>();
        this.cvv = 0;
    } 

    /**
      * Parameterized constructor
      * @param customerName
      * @param customerEmail
      * @param reservationIDs integer list of reservation ids associated with customer
      * @param isAdmin
      */
    protected Customer(String customerName, String customerEmail,String customerPassword,
            ArrayList<String> reservationIDs,boolean isAdmin, String customerAddress,
            int customerZip,int[] cardNum, String expiry, int[] phoneNum,int cvv) {
        this.isAdmin = isAdmin;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.reservationIDs = reservationIDs;
        this.customerAddress = customerAddress;
        this.customerZip = customerZip;
        this.cardNum = cardNum;
        this.expiry = expiry;
        this.phoneNum = phoneNum;
        this.cvv = cvv;
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
     * Getter method for getting the email of the customer
     * @return String of customer password
     */
    public String getCustomerPass(){
        return customerPassword;
    }
    
    /**
     * Setter method for setting the customerPassword variable
     * @param customerPassword 
     */
    public void setCustomerPass(String customerPassword){
        this.customerPassword = customerPassword;
    }
    /**
     * Getter method for getting the reservation IDs associated with customer
     * @return An ArrayList of reservationIDs
     */
    protected ArrayList<String> getReservationIDs() {
        return reservationIDs;
    }

    /**
     * Setter method for setting the reservationIDs list in customer object
     * @param reservationIDs ArrayList of Integers to be assigned to reservationIDs variable
     */
    protected void setReservationIDs(ArrayList<String> reservationIDs) {
        this.reservationIDs.addAll(reservationIDs);
    }
    
    protected void setIsAdmin (boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    
    
}
