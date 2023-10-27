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
    }
    
    /**
     * Parameterized constructor.
     * @param ID
     * @param checkIn
     * @param checkOut
     * @param room 
     */
    public Reservation(String ID, LocalDate checkIn, LocalDate checkOut, Room room){
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut= checkOut;
        this.room = room;
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
        String row = 
                    "\n"+ ID + "," + 
                    checkIn + "," + 
                    checkOut + "," +
                    room.roomNum + "," + 
                    room.smoking + "," +
                    room.numBeds + "," +
                    room.numPeople + "," + 
                    room.sqftSize + "," + 
                    room.bedType + "," +
                    room.description;
        
        FileController.appendFile("Reservations.csv",row); 
    }
}