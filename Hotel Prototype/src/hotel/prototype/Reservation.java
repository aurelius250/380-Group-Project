package hotel.prototype;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Reservation class object. Stores ID, Check in/out date, room associated, and 
 * the customer associated.
 * @author K.Maki
 */
public class Reservation {
    public String ID;
    public LocalDate checkIn;
    public LocalDate checkOut;
    public Room room;
    public Customer customer;
    
    /**
     * Default constructor.
     */
    public Reservation(){
        ID = null;
        checkIn = null;
        checkOut = null;
        room = null;
        customer = null;
    }
    
    /**
     * Parameterized constructor.
     * @param ID
     * @param checkIn
     * @param checkOut
     * @param room 
     * @param customer
     */
    public Reservation(String ID, LocalDate checkIn, LocalDate checkOut, Room room, Customer customer){
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut= checkOut;
        this.room = room;
        this.customer = customer;
    }
    
    /**
     * Outputs reservation details.
     */
    public void listDetails(){
        System.out.println(
                "Reservation ID: " + this.ID + 
                "\nCheck In:  " + this.checkIn + 
                "\nCheck Out: " + this.checkOut +
                "\nRoom Number: " + this.room.getRoomNum() +
                "\nSmoking?: " + this.room.getSmoking() +
                "\n# of Beds: " + this.room.getNumBeds() +
                "\n# of People: " + this.room.getNumPeople() +
                "\nSize (sqft): " + this.room.getSqftSize() +
                "\nBed Type: " + this.room.getBedType() +
                "\nDescription: " + this.room.getDescription() +
                "\nCustomer Name: " + this.customer.getCustomerName() +
                "\nCustomer Email: " + this.customer.getCustomerEmail()
        );
    }
    
    /**
     * Appends reservation data to the reservations file.
     * @throws IOException 
     */
    public void addReservation() throws IOException{
        FileController.appendFile("src/hotel/prototype/Reservations.csv",
                "\n" + this.toStringCSV()); 
    }
    
    public String toStringCSV(){
        String row = 
                    ID + "," + 
                    checkIn + "," + 
                    checkOut + "," +
                    room.getRoomNum() + "," + 
                    room.getSmoking() + "," +
                    room.getNumBeds() + "," +
                    room.getNumPeople() + "," + 
                    room.getSqftSize() + "," + 
                    room.getBedType() + "," +
                    room.getDescription() + "," +
                    customer.getCustomerName() + "," +
                    customer.getCustomerEmail();
        
        return row;
    }
}