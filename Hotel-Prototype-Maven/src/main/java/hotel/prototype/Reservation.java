/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author keato
 */
public class Reservation {
    
    public String ID;
    public LocalDate checkIn,checkOut;
    public Room room;
    
    //private Customer customer;
    
    public Reservation(){
        ID = null;
        checkIn = null;
        checkOut = null;
        room = null;
    }
    
    public Reservation(String ID, LocalDate checkIn, LocalDate checkOut, Room room){
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut= checkOut;
        this.room = room;
    }
    
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
