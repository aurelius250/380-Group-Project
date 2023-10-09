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
    public LocalDate checkIn,checkOut;
    public Room room;
    //private Customer customer;
    
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
                "\nRoom Number: " + this.room.roomNum +
                "\nSmoking?: " + this.room.smoking +
                "\n# of Beds: " + this.room.numBeds +
                "\n# of People: " + this.room.numPeople +
                "\nSize (sqft): " + this.room.sqftSize +
                "\nBed Type: " + this.room.bedType +
                "\nDescription: " + this.room.description
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