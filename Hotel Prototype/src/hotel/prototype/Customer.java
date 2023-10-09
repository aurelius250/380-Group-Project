/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Customer Email: ").append(customerEmail).append("\n");
        sb.append("Reservation IDs: ").append(reservationIDs).append("\n");
        return sb.toString();
    }
    
    protected Customer() { 
        this.customerName = ""; 
        this.customerEmail = ""; 
        this.reservationIDs = new ArrayList<>();
    } 

    protected Customer(String customerName, String customerEmail, ArrayList<Integer> reservationIDs) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.reservationIDs = reservationIDs;
    }    
    
    protected String getCustomerName() {
        return customerName;
    }

    protected void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    protected String getCustomerEmail() {
        return customerEmail;
    }

    protected void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    protected ArrayList<Integer> getReservationIDs() {
        return reservationIDs;
    }

    protected void setReservationIDs(ArrayList<Integer> reservationIDs) {
        this.reservationIDs = reservationIDs;
    }
    
}
